package com.cognizant.stepDefinition;

import com.cognizant.utilities.PdfUtils;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.File;
import java.util.List;
import java.util.Map;

public class PdfStepDefinitions {

    @Then("the PDF {string} should contain text {string}")
    public void verifyPdfContainsText(String pdfName, String expectedText) throws Exception {
        File pdf = PdfUtils.getPdfFromResources(pdfName);
        boolean result = PdfUtils.containsText(pdf.getAbsolutePath(), expectedText);
        Assert.assertTrue(result, "Expected text not found in PDF: " + pdfName);
    }

    @Then("the PDF {string} should have {int} pages")
    public void verifyPdfPageCount(String pdfName, int expectedPageCount) throws Exception {
        File pdf = PdfUtils.getPdfFromResources(pdfName);
        int actualPageCount = PdfUtils.getPageCount(pdf.getAbsolutePath());
        Assert.assertEquals(actualPageCount, expectedPageCount, "Page count mismatch in PDF: " + pdfName);
    }

    @Then("the PDF {string} should match {string}")
    public void compareTwoPdfs(String actualPdfName, String expectedPdfName) throws Exception {
        File actual = PdfUtils.getPdfFromResources(actualPdfName);
        File expected = PdfUtils.getPdfFromResources(expectedPdfName);
        boolean match = PdfUtils.comparePdfText(actual.getAbsolutePath(), expected.getAbsolutePath());
        Assert.assertTrue(match, "PDF contents do not match between " + actualPdfName + " and " + expectedPdfName);
    }
    @Then("the PDF {string} should match {string} with detailed report")
    public void compareTwoPdfsWithReport(String actualPdfName, String expectedPdfName) throws Exception {
        File actual = PdfUtils.getPdfFromResources(actualPdfName);
        File expected = PdfUtils.getPdfFromResources(expectedPdfName);

        Map<Integer, List<String>> report = PdfUtils.comparePdfWithReport(
                actual.getAbsolutePath(), expected.getAbsolutePath());

        if (!report.isEmpty()) {
            StringBuilder sb = new StringBuilder("PDF mismatches found:\n");
            report.forEach((page, diffs) -> {
                sb.append("Page ").append(page).append(":\n");
                diffs.forEach(diff -> sb.append(diff).append("\n"));
            });
            Assert.fail(sb.toString());
        }
    }

}
