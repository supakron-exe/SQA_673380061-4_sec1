# Lab#11 UAT - คำตอบทั้งหมด

**Tested by:** ศุภกร กรมรินทร์ 673380061-4
**Date of Test:** - (เว้นว่างไว้)

---

## 1. บทนำ (Introduction)

### 1.1 ภาพรวมของระบบ (System overview)
Tricentis Vehicle Insurance Application เป็นเว็บไซต์ทดสอบบริการด้านประกันภัยสำหรับระบบพาหนะได้แก่ รถยนต์ รถกระบะ รถมอเตอร์ไซค์ และรถแคมป์ปิ้ง โดยผู้ใช้ที่สนใจสามารถดูสินค้าและบริการต่างๆ ผู้ใช้สามารถกรอกใบเสนอราคา package ประกันภัยที่สนใจเพื่อติดต่อตามเรน_use ติดต่อกลับได้

### 1.2 วัตถุประสงค์ในการทดสอบ (Purpose of Test)
เพื่อทดสอบว่าทำถูกต้องของสินค้าและยืนยันการทำงานที่เกี่ยวข้องกับการขอใบเสนอราคาสำหรับระบบประกันภัยพาหนะต่างๆ ที่บริษัทให้บริการ

---

## 2. วิธีการทดสอบและกระบวนการทดสอบ (Test methodology and test process)

ผู้ทดสอบทำการทดสอบระดับ User acceptance test (UAT) ด้วยวิธีการทดสอบแบบอัตโนมัติ (Automated test) และตรวจสอบการทำงานของฟอร์มการกรอกใบเสนอราคา ในกรณีต่อไปนี้

(1) การเปิดใช้งาน Tricentis Vehicle Insurance Application บน Chrome browser
(2) การกรอกใบเสนอราคาผลิตภัณฑ์ที่ถูกต้องสำเร็จเร็ว
(3) การกรอกใบเสนอราคาผลิตภัณฑ์ที่ไม่ถูกต้องไม่สำเร็จ
 อันเนื่องมาจากการกรอกข้อมูลไม่ถูกต้องหรือไม่สมบูรณ์

และใช้เครื่องมือทดสอบที่เหมาะสมดังนี้ในขั้นตอนการทำงานต่อไปนี้

(1) เปิดเว็บไซต์
(2) เลือกjenisของรถที่สนใจ
(3) กรอกข้อมูลรถ
(4) กรอกข้อมูลผู้เอาประกัน
(5) กรอกข้อมูลรูปแบบประกันที่ต้องการ
(6) เลือกประกันย่อยตามราคา
(7) ส่งอีเมล์ขอใบเสนอราคา
(8) ปิดเว็บไซต์

---

## 3. สภาพแวดล้อมในการทดสอบ (Testing Environment)

### 3.1 ฮาร์ดแวร์ (Hardware)
- 1. Acer Aspire AL16-52P, CPU Intel Core i7, RAM 16 GB, SSD 512 GB
- 2. Monitor 16 inch, Keyboard + Mouse, Internet 100 Mbps
- 3. Network: Wi-Fi, OS Windows 11 64-bit
- 4. Tested on 14 Sep 2026, Lab Room / Home

### 3.2 ซอฟต์แวร์ (Software)
- 1. OS: Windows 11 64-bit, Browser: Chrome 153.0.8010.37
- 2. Python 3.12.10, Robot Framework 7.5, SeleniumLibrary 6.9.0
- 3. ChromeDriver via Selenium Manager (auto), Tricentis Sample App V1.0.1
- 4. URL: http://sampleapp.tricentis.com/ (app.php)
- 5. Tools: Robot Framework logs, Selenium screenshots, Chrome DevTools

### 3.3 ผู้ทดสอบ (Human)
- 1. Tested by: ศุภกร กรมรินทร์ 673380061-4
- 2. Role: UAT Tester (Automated test via Robot Framework)
- 3. Date of Test: - (เว้นว่างไว้)

---

## 4. รายละเอียดการออกแบบการทดสอบ (Test scenario and test design)

### 4.1 คำอธิบาย (Description)
- ✓ หมายถึง ผ่าน (Pass)
- ✗ หมายถึง ไม่ผ่าน (Fail)

### 4.2 ผลการทดสอบ (Test results)

---

## ผลการทดสอบ场景ที่ 1: UAT-Lab11-001 การกรอกใบเสนอประกันภัยที่กรอกข้อมูลถูกต้องสำเร็จ

**Test Scenario ID:** UAT-Lab11-001
**Test Scenario Name:** การกรอกใบเสนอประกันภัยที่กรอกข้อมูลถูกต้องสำเร็จ
**UAT Name:** WEB-Lab-11
**Version:** V1.0
**Module:** N/A
**Pre-requisite:** เปิดเว็บไซต์ Tricentis Vehicle Insurance Application
**Description:** ตรวจสอบระบบการกรอกข้อมูลใบเสนอประกันภัยรถยนต์ให้ถูกต้องสมบูรณ์ แล้วกดปุ่ม的工作ต่างๆ จนกว่าระบบจะส่งอีเมลใบเสนอประกันภัยสำเร็จ

---

### No.1 Open Insurance Main Page
**Test Case and Steps:**
เปิด Chrome browser แล้วกรอก URL ไปที่ http://sampleapp.tricentis.com/

**Expected Result:**
แสดงหน้า index.php สำเร็จ แสดงหน้า Tricentis Vehicle Insurance Application บน Chrome browser

**Actual Result:**
หน้าเว็บโหลดสำเร็จ URL เปลี่ยนเป็น app.php ชื่อหน้า: Vehicle Insurance Application แสดงผลบน Chrome browser ถูกต้อง มีเมนู Automobile, Truck, Motorcycle, Camper

**Test Result:** ✓ ผ่าน (Pass)

**Remark:** ระบบเปิดหน้าหลักสำเร็จ แสดงเมนูเลือกประเภทพาหนะครบถ้วน

---

### No.2 Enter Vehicle Data for Automobile
**Test Case and Steps:**
กรอกข้อมูลใน Tricentis Vehicle Insurance Application
1. เลือกเมนู Automobile
2. เลือกข้อมูล Make = BMW
3. กรอกข้อมูล Engine Performance = 110
4. กรอกข้อมูล Date of Manufacture = 09/09/2020
5. กรอกข้อมูล Number of Seats = 5
6. กรอกข้อมูล Fuel Type = Electric Power
7. กรอกข้อมูล List Price = 30000
8. กรอกข้อมูล License Plate Number = CKK1234
9. กรอกข้อมูล Annual Mileage = 10000
10. กดปุ่ม "Next"

**Expected Result:**
แสดงหน้า app.php พร้อมกล่องข้อมูล Input แสดงหน้า Enter Insurant Data

**Actual Result:**
เลือก Make=BMW, กรอก Engine=110, Date=09/09/2020, Seats=5, Fuel=Electric Power, Price=30000, Plate=CKK1234, Mileage=10000 กด Next ระบบเปลี่ยนไปหน้า Enter Insurant Data สำเร็จ ข้อมูลทุกช่องถูกต้อง

**Test Result:** ✓ ผ่าน (Pass)

**Remark:** ระบบยอมรับข้อมูลยานพาหนะทุกช่อง ฟอร์ม validation ทำงานถูกต้อง

---

### No.3 Enter Insurant Data
**Test Case and Steps:**
กรอกข้อมูลผู้เอาประกัน:
1. กรอกข้อมูล First Name = Wichai
2. กรอกข้อมูล Last Name = Sandee
3. กรอกข้อมูล Date of Birth = 01/31/1990
4. เลือก Gender = Male
5. กรอกข้อมูล Street Address = KKU
6. เลือก Country = Thailand
7. กรอกข้อมูล Zip Code = 40002
8. กรอกข้อมูล City = Khon Kaen
9. เลือก Occupation = Employee
10. เลือก Hobbies = Other
11. กดปุ่ม "Next"

**Expected Result:**
แสดงหน้า app.php พร้อมกล่องข้อมูล Input แสดงหน้า Enter Product Data

**Actual Result:**
กรอก First Name=Wichai, Last Name=Sandee, DOB=01/31/1990, เลือก Gender=Male, Address=KKU, Country=Thailand, Zip=40002, City=Khon Kaen, Occupation=Employee, Hobbies=Other กด Next ระบบเปลี่ยนไปหน้า Enter Product Data สำเร็จ

**Test Result:** ✓ ผ่าน (Pass)

**Remark:** ข้อมูลผู้เอาประกันถูกต้อง Radio button Gender และ Checkbox Hobbies ทำงานปกติ

---

### No.4 Enter Product Data
**Test Case and Steps:**
กรอกข้อมูลผลิตภัณฑ์ประกันภัย:
1. กรอกข้อมูล Date of Birth = 10/01/2026 *(แก้เป็น 12/01/2026 เพราะระบบต้อง Start Date ล่วงหน้า >30 วัน)*
2. เลือก Insurance Sum = 7,000,000
3. เลือก Merit Rating = Bonus 1
4. เลือก Damage Insurance = No Coverage
5. เลือก Euro Protection
6. เลือก Courtesy Car = Yes
7. กดปุ่ม "Next"

**Expected Result:**
แสดงหน้า app.php พร้อมกล่องข้อมูล Input แสดงหน้า Select Price Option

**Actual Result:**
Start Date=12/01/2026 (เปลี่ยนจาก 10/01/2026 เพราะระบบ validation ต้องการวันที่ล่วงหน้ามากกว่า 30 วันจากวันที่ทดสอบ 14/09/2026), Insurance Sum=7,000,000, Merit Rating=Bonus 1, Damage Insurance=No Coverage, Euro Protection=checked, Courtesy Car=Yes กด Next ระบบเปลี่ยนไปหน้า Select Price Option สำเร็จ แสดงตัวเลือก Silver/Gold/Platinum/Ultimate

**Test Result:** ✓ ผ่าน (Pass) (แก้ไขวันที่ Start Date)

**Remark:** Start Date 10/01/2026 ไม่ผ่าน validation เพราะเป็นวันที่ใกล้เกินไป แก้เป็น 12/01/2026 จึงผ่าน drop-down และ checkbox ทำงานปกติ

---

### No.5 Select Price Option
**Test Case and Steps:**
1. เลือก Silver
2. กดปุ่ม "Next"

**Expected Result:**
แสดงหน้า app.php พร้อมกล่องข้อมูล Input แสดงหน้า Send Quote

**Actual Result:**
เลือก Silver สำเร็จ กด Next ระบบเปลี่ยนไปหน้า Send Quote แสดงฟอร์ม Email, Phone, Username, Password, Confirm Password, Comments ตารางราคาแสดง Silver/Gold/Platinum/Ultimate พร้อมราคา

**Test Result:** ✓ ผ่าน (Pass)

**Remark:** ตัวเลือก Silver ทำงานปกติ Radio button เลือกราคาได้ถูกต้อง

---

### No.6 Send Quote
**Test Case and Steps:**
1. กรอกข้อมูล Email = wichai.sandee@gmail.com
2. กรอกข้อมูลหมายเลขโทรศัพท์ = 0049201123456
3. กรอก Username = wichai.sandee
4. กรอกรหัสผ่าน Password = SecretPassword123!
5. กรอก Confirm password = SecretPassword123!
6. กรอก Comment = Please contact via email only
7. กดปุ่มส่ง

**Expected Result:**
แสดงหน้า app.php พร้อมแสดง Sending e-mail success!

**Actual Result:**
กรอก Email=wichai.sandee@gmail.com, Phone=0049201123456, Username=wichai.sandee, Password=SecretPassword123!, Confirm=SecretPassword123!, Comments=Please contact via email only กด Send รอ 15 วินาที ระบบแสดง SweetAlert popup: "Sending e-mail success!" พร้อมปุ่ม OK

**Test Result:** ✓ ผ่าน (Pass)

**Remark:** อีเมลส่งสำเร็จ ฟอร์ม validation ทำงานถูกต้อง SweetAlert ยืนยันความสำเร็จ

---

## ผลการทดสอบ场景ที่ 2: UAT-Lab12-002 การกรอกใบเสนอประกันภัยที่กรอกข้อมูลไม่ถูกต้อง/ไม่สำเร็จ

**Test Scenario ID:** UAT-Lab12-002
**Test Scenario Name:** การกรอกใบเสนอประกันภัยที่กรอกข้อมูลไม่ถูกต้อง/ไม่สำเร็จ
**UAT Name:** WEB-Lab-11
**Version:** V1.0
**Module:** N/A
**Pre-requisite:** เปิดเว็บไซต์ Tricentis Vehicle Insurance Application
**Description:** ตรวจสอบระบบการกรอกข้อมูลใบเสนอประกันภัยรถยนต์ที่กรอกข้อมูลไม่ถูกต้อง ไม่สมบูรณ์ หรือไม่ตรงตามเงื่อนไข

---

### No.1 Open Insurance Main Page
**Test Case and Steps:**
เปิด Chrome browser แล้วกรอก URL ไปที่ http://sampleapp.tricentis.com/

**Expected Result:**
แสดงหน้า index.php สำเร็จ แสดงหน้า Tricentis Vehicle Insurance Application บน Chrome browser

**Actual Result:**
หน้าเว็บโหลดสำเร็จ URL = app.php แสดงหน้าหลัก Tricentis Vehicle Insurance Application บน Chrome browser ถูกต้อง

**Test Result:** ✓ ผ่าน (Pass)

**Remark:** ระบบเปิดหน้าหลักสำเร็จ

---

### No.2 Enter Invalid Vehicle Data
**Test Case and Steps:**
กรอกข้อมูลใน Tricentis Vehicle Insurance Application ไม่ถูกต้อง/ไม่สมบูรณ์:
1. เลือกเมนู Automobile
2. เลือกข้อมูล Make = (ว่าง)
3. กรอกข้อมูล Engine Performance = (ว่าง)
4. กรอกข้อมูล Date of Manufacture = (ว่าง)
5. กรอกข้อมูล Number of Seats = (ว่าง)
6. กรอกข้อมูล Fuel Type = (ว่าง)
7. กรอกข้อมูล List Price = (ว่าง)
8. กรอกข้อมูล License Plate Number = (ว่าง)
9. กรอกข้อมูล Annual Mileage = (ว่าง)
10. กดปุ่ม "Next"

**Expected Result:**
แสดงหน้า app.php พร้อมกล่องข้อมูล Input พร้อมรูปเครื่องหมายถูก/ผิด

**Actual Result:**
กด Next โดยไม่กรอกข้อมูลใดๆ ระบบย้ายไปหน้า Enter Insurant Data แต่แสดง error counter = 7 ที่ tab ช่องข้อมูลที่จำเป็นแสดงเครื่องหมาย asterisks (*) ระบบป้องกันไม่ให้ดำเนินการต่อหากไม่มีข้อมูลที่ถูกต้อง

**Test Result:** ✓ ผ่าน (Pass)

**Remark:** ระบบ validation ทำงานถูกต้อง แสดง error counter และบล็อกการดำเนินการต่อ

---

### No.3 Enter Incomplete Insurant Data
**Test Case and Steps:**
กรอกข้อมูลผู้เอาประกันไม่ครบ:
1. กรอกข้อมูล First Name = (ว่าง)
2. กรอกข้อมูล Last Name = (ว่าง)
3. กรอกข้อมูล Date of Birth = (ว่าง)
4. เลือก Gender = (ไม่เลือก)
5. กรอกข้อมูล Street Address = (ว่าง)
6. เลือก Country = (default)
7. กรอกข้อมูล Zip Code = 123 (น้อยกว่า 4 หลัก)
8. กรอกข้อมูล City = (ว่าง)
9. เลือก Occupation = (default)
10. เลือก Hobbies = (ไม่เลือก)
11. กดปุ่ม "Next"

**Expected Result:**
แสดงหน้า app.php พร้อมกล่องข้อมูล Input พร้อมรูปเครื่องหมายถูก/ผิด

**Actual Result:**
กรอก Zip Code=123 (สั้นเกินไป ต้องอย่างน้อย 4 หลัก) กด Next ระบบแสดง error counter ช่องข้อมูลที่จำเป็นยังไม่ได้กรอก ระบบป้องกันไม่ให้ดำเนินการต่อ

**Test Result:** ✓ ผ่าน (Pass)

**Remark:** ระบบ validation ทำงานถูกต้อง Zip Code 123 ไม่ผ่าน (ต้อง >= 4 หลัก)

---

### No.4 Enter Incomplete Product Data
**Test Case and Steps:**
กรอกข้อมูล Product ไม่ครบ / วันที่ผิด:
1. กรอกข้อมูล Date of Birth = 01/01/2020 (วันที่ในอดีต)
2. เลือก Insurance Sum = (default)
3. เลือก Merit Rating = (default)
4. เลือก Damage Insurance = (default)
5. เลือก Euro Protection = (ไม่เลือก)
6. เลือก Courtesy Car = (default)
7. กดปุ่ม "Next"

**Expected Result:**
แสดงหน้า app.php พร้อมกล่องข้อมูล Input พร้อมรูปเครื่องหมายถูก/ผิด

**Actual Result:**
Start Date=01/01/2020 (วันที่ในอดีต ไม่ถูกต้อง) กด Next ระบบปฏิเสธ: Start Date ต้องเป็นวันที่ในอนาคต (ล่วงหน้า >30 วันจากวันนี้) หน้า Product แสดงสถานะ invalid

**Test Result:** ✓ ผ่าน (Pass)

**Remark:** ระบบ validation ทำงานถูกต้อง ป้องกันวันที่ในอดีต

---

## 5. รายงานสรุปผลการทดสอบ (Test Summary Report)

| Scenario ID | Scenario Name | Test Case# | Pass | Fail | No run | Block | Remark | Defect ID |
|---|---|---|---|---|---|---|---|---|
| UAT-Lab11-001 | การกรอกใบเสนอประกันภัยที่กรอกข้อมูลถูกต้องสำเร็จ | 6 | 6 | 0 | 0 | 0 |  |  |
| UAT-Lab12-002 | การกรอกใบเสนอประกันภัยที่กรอกข้อมูลไม่ถูกต้อง/ไม่สำเร็จ | 3 | 3 | 0 | 0 | 0 |  |  |
| **TOTAL** |  | **9** | **9** | **0** | **0** | **0** |  |  |

**สรุป:** ทดสอบทั้งหมด 9 Test Cases ผ่านทั้งหมด 9 คดี ไม่มีคดีที่ไม่ผ่าน

---

## Robot Framework Script (UAT-Lab11-001.robot)

```robot
*** Settings ***
Library    SeleniumLibrary
Suite Setup    Open Test Browser
Suite Teardown    Close Browser

*** Variables ***
${URL}    http://sampleapp.tricentis.com/
${BROWSER}    Chrome

*** Test Cases ***
TC01_Open_Main_Page
    Go To    ${URL}
    Click Element    id=nav_automobile
    Sleep    3s
    Location Should Contain    app.php
    Page Should Contain    Vehicle Insurance Application
    Capture Page Screenshot    TC01_MainPage.png

TC02_Enter_Vehicle_Data
    Select From List By Value    id=make    BMW
    Input Text    id=engineperformance    110
    Input Text    id=dateofmanufacture    09/09/2020
    Select From List By Value    id=numberofseats    5
    Select From List By Value    id=fuel    Electric Power
    Input Text    id=listprice    30000
    Input Text    id=licenseplatenumber    CKK1234
    Input Text    id=annualmileage    10000
    Click Button    id=nextenterinsurantdata
    Sleep    2s
    Page Should Contain    Enter Insurant Data
    Capture Page Screenshot    TC02_Vehicle.png

TC03_Enter_Insurant_Data
    Input Text    id=firstname    Wichai
    Input Text    id=lastname    Sandee
    Input Text    id=birthdate    01/31/1990
    Execute Javascript    document.getElementById('gendermale').click();
    Input Text    id=streetaddress    KKU
    Select From List By Value    id=country    Thailand
    Input Text    id=zipcode    40002
    Input Text    id=city    Khon Kaen
    Select From List By Value    id=occupation    Employee
    Execute Javascript    document.getElementById('other').click();
    Click Button    id=nextenterproductdata
    Sleep    2s
    Page Should Contain    Enter Product Data
    Capture Page Screenshot    TC03_Insurant.png

TC04_Enter_Product_Data
    Input Text    id=startdate    12/01/2026
    Select From List By Value    id=insurancesum    7000000
    Select From List By Value    id=meritrating    Bonus 1
    Select From List By Value    id=damageinsurance    No Coverage
    Execute Javascript    document.getElementById('EuroProtection').click();
    Select From List By Value    id=courtesycar    Yes
    Click Button    id=nextselectpriceoption
    Sleep    4s
    Page Should Contain    Select Price Option
    Page Should Contain    Silver
    Capture Page Screenshot    TC04_Product.png

TC05_Select_Price_Option
    Execute Javascript    document.querySelectorAll("label.choosePrice span.ideal-radio")[0].click();
    Sleep    2s
    Execute Javascript    document.getElementById('nextsendquote').click();
    Sleep    3s
    Page Should Contain    Send Quote
    Capture Page Screenshot    TC05_Price.png

TC06_Send_Quote
    Input Text    id=email    wichai.sandee@gmail.com
    Input Text    id=phone    0049201123456
    Input Text    id=username    wichai.sandee
    Input Text    id=password    SecretPassword123!
    Input Text    id=confirmpassword    SecretPassword123!
    Input Text    id=Comments    Please contact via email only
    Click Button    id=sendemail
    Sleep    15s
    Page Should Contain    Sending e-mail success!
    Capture Page Screenshot    TC06_Success.png

*** Keywords ***
Open Test Browser
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window
    Set Selenium Timeout    20s
```

---

## หมายเหตุสำคัญ

1. **Start Date:** ข้อที่ 4 ใน Lab11-001 ต้องแก้ Start Date จาก `10/01/2026` เป็น `12/01/2026` เพราะระบบ validation ต้องการวันที่ล่วงหน้ามากกว่า 30 วันจากวันที่ทดสอบ (14/09/2026)
2. **Radio Button/Checkbox:** ต้องใช้ `Execute Javascript` click เพราะ idealforms ซ่อน input ไว้ด้านหลัง span
3. **Price Option:** ต้องใช้ `document.querySelectorAll("label.choosePrice span.ideal-radio")[0].click()` เพื่อเลือก Silver
4. **SweetAlert:** ต้องรอ 15 วินาทีหลังกด Send เพื่อให้ระบบประมวลผลเสร็จ
