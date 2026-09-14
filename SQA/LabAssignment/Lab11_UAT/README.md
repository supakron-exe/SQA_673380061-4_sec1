# Lab#11 – User Acceptance Test (UAT)

CP353201 Software Quality Assurance (1/2569)

Automated UAT for the **Tricentis Vehicle Insurance Application** using **Robot Framework** + **SeleniumLibrary**.

## Files

| File | Description |
|------|-------------|
| `Lab11_TestScript_Insurance.pdf` | Completed UAT report (test scenarios, results, summary) |
| `Lab11_Answers.md` | Full answers / reference (Markdown version) |
| `robot/UAT-Lab11-001.robot` | Success scenario - valid quote request |
| `robot/UAT-Lab11-002.robot` | Fail scenario - invalid/incomplete data |
| `robot/results/` | Robot Framework output: `report.html`, `log.html`, screenshots |

## Scenarios

- **UAT-Lab11-001** (6 test cases) – Success: fill vehicle/insurant/product data, select Silver price option, send quote up to *"Sending e-mail success!"*.
- **UAT-Lab11-002** (3 test cases) – Fail: invalid/incomplete data must be rejected by form validation (error counter, past date rejection).

## Run

```powershell
cd robot
robot --outputdir results UAT-Lab11-001.robot
robot --outputdir results UAT-Lab11-002.robot
# or run both at once
robot --outputdir results UAT-Lab11-001.robot UAT-Lab11-002.robot
```

Requires: Python 3.7+, `pip install robotframework robotframework-seleniumlibrary`.

## Environment used

- Windows 11 64-bit, Chrome 153.0.8010.37
- Python 3.12.10, Robot Framework 7.5, SeleniumLibrary 6.9.0
- Target: `http://sampleapp.tricentis.com/`