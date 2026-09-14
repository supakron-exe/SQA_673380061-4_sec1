*** Settings ***
Library    SeleniumLibrary
Suite Setup    Open Test Browser
Suite Teardown    Close Browser

*** Variables ***
${URL}    http://sampleapp.tricentis.com/
${BROWSER}    Chrome

*** Test Cases ***
TC01_Open_Main_Page
    [Documentation]    No.1 Open Insurance Main Page
    Go To    ${URL}
    Click Element    id=nav_automobile
    Sleep    3s
    Location Should Contain    app.php
    Page Should Contain    Tricentis Vehicle Insurance

TC02_Enter_Invalid_Vehicle_Data
    [Documentation]    No.2 กรอกข้อมูลรถไม่ถูกต้อง/ไม่สมบูรณ์ (เว้นว่าง required fields)
    # 1. เลือกเมนู Automobile (ทำแล้วใน TC01)
    # 2. Make = ว่าง (default)
    # 3. Engine Performance = ว่าง
    # 4. Date of Manufacture = ว่าง / รูปแบบผิด
    # 5. Number of Seats = ว่าง
    # 6. Fuel Type = ว่าง
    # 7. List Price = ว่าง
    # 8. License Plate Number = ว่าง
    # 9. Annual Mileage = ว่าง
    # 10. กด Next
    Click Button    id=nextenterinsurantdata
    Sleep    3s
    # Expected: ระบบแสดงตัวนับ error (counter) ที่ tab, ไม่สามารถขอใบเสนอราคาสำเร็จได้
    # ตรวจสอบว่ายังไม่สามารถไปถึง Send Quote สำเร็จ (ยังไม่มี price ที่ถูกต้อง)
    Page Should Not Contain    Sending e-mail success!
    Capture Page Screenshot    FAIL_TC02_Vehicle.png

TC03_Enter_Incomplete_Insurant_Data
    [Documentation]    No.3 กรอกข้อมูลผู้เอาประกันไม่ครบ
    # 1. First Name = ว่าง
    # 2. Last Name = ว่าง
    # 3. Date of Birth = ว่าง
    # 4. Gender = ไม่เลือก
    # 5. Street Address = ว่าง
    # 6. Country = default
    # 7. Zip Code = ว่าง (หรือน้อยกว่า 4 หลัก เช่น 123)
    # 8. City = ว่าง
    # 9. Occupation = default
    # 10. Hobbies = ไม่เลือก
    # 11. กด Next
    Input Text    id=zipcode    123
    Click Button    id=nextenterproductdata
    Sleep    2s
    Page Should Not Contain    Sending e-mail success!
    Capture Page Screenshot    FAIL_TC03_Insurant.png

TC04_Enter_Incomplete_Product_Data
    [Documentation]    No.4 กรอกข้อมูล Product ไม่ครบ / วันที่อดีต
    # 1. Start Date = 01/01/2020 (อดีต - invalid, ต้องเป็นอนาคต >30 วัน)
    # 2. Insurance Sum = default
    # 3. Merit Rating = default
    # 4. Damage Insurance = default
    # 5. Euro Protection = ไม่เลือก
    # 6. Courtesy Car = default
    # 7. กด Next
    Input Text    id=startdate    01/01/2020
    Click Button    id=nextselectpriceoption
    Sleep    4s
    Page Should Not Contain    Sending e-mail success!
    Capture Page Screenshot    FAIL_TC04_Product.png

*** Keywords ***
Open Test Browser
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window
    Set Selenium Timeout    20s
