Feature: PDF Validation

  Scenario: Verify PDF contains specific text
    Then the PDF "actual.pdf" should contain text "Manager Attestation"

  Scenario: Verify PDF page count
    Then the PDF "actual.pdf" should have 1 pages


  Scenario: Compare two PDFs with detailed report
    Then the PDF "actual.pdf" should match "expected.pdf" with detailed report
