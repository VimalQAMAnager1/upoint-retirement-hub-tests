package com.cognizant.utilities;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PdfUtils {

    public static File getPdfFromResources(String fileName) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource("pdfs/" + fileName);

        if (resource == null) {
            throw new IOException("PDF file not found: " + fileName);
        }
        return new File(resource.toURI());
    }

    public static String extractText(String filePath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }

    public static boolean containsText(String filePath, String expectedText) throws IOException {
        String content = extractText(filePath);
        return content.contains(expectedText);
    }

    public static int getPageCount(String filePath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            return document.getNumberOfPages();
        }
    }

    public static boolean comparePdfText(String file1, String file2) throws IOException {
        String text1 = extractText(file1).replaceAll("\\s+", "");
        String text2 = extractText(file2).replaceAll("\\s+", "");
        return text1.equals(text2);
    }





        public static List<String> extractTextByPage(String filePath) throws IOException {
            List<String> pages = new ArrayList<>();
            try (PDDocument document = PDDocument.load(new File(filePath))) {
                PDFTextStripper stripper = new PDFTextStripper();
                int pageCount = document.getNumberOfPages();
                for (int i = 1; i <= pageCount; i++) {
                    stripper.setStartPage(i);
                    stripper.setEndPage(i);
                    pages.add(stripper.getText(document));
                }
            }
            return pages;
        }

        /**
         * Compare two PDFs and return a mismatch report.
         * Report format: Map<PageNumber, List of differences>
         */
        public static Map<Integer, List<String>> comparePdfWithReport(String file1, String file2) throws IOException {
            List<String> pdf1Pages = extractTextByPage(file1);
            List<String> pdf2Pages = extractTextByPage(file2);

            Map<Integer, List<String>> mismatchReport = new LinkedHashMap<>();

            int maxPages = Math.max(pdf1Pages.size(), pdf2Pages.size());

            for (int i = 0; i < maxPages; i++) {
                String page1 = i < pdf1Pages.size() ? pdf1Pages.get(i) : "";
                String page2 = i < pdf2Pages.size() ? pdf2Pages.get(i) : "";

                if (!page1.equals(page2)) {
                    List<String> differences = new ArrayList<>();

                    String[] lines1 = page1.split("\\r?\\n");
                    String[] lines2 = page2.split("\\r?\\n");

                    int maxLines = Math.max(lines1.length, lines2.length);

                    for (int j = 0; j < maxLines; j++) {
                        String line1 = j < lines1.length ? lines1[j] : "";
                        String line2 = j < lines2.length ? lines2[j] : "";

                        if (!line1.equals(line2)) {
                            differences.add("Line " + (j + 1) + " mismatch:\nExpected: " + line2 + "\nActual:   " + line1);
                        }
                    }

                    mismatchReport.put(i + 1, differences); // Page numbers are 1-based
                }
            }

            return mismatchReport;
        }
    }


