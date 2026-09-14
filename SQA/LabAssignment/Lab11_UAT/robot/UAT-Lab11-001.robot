*** Settings ***
Library    SeleniumLibrary
Suite Setup    Open Test Browser
Suite Teardown    Close Browser

*** Variables ***
${URL}    http://sampleapp.tricentis.com/
${BROWSER}    Chrome

*** Test Cases ***
TC01_Open_Main_Page
    [Documentation]    No.1 Open Insurance Main Page - เปิด Chrome แล้วกรอก URL
    Go To    ${URL}
    Click Element    id=nav_automobile
    Sleep    3s
    Location Should Contain    app.php
    Page Should Contain    Vehicle Insurance Application
    Capture Page Screenshot    TC01_MainPage.png

TC02_Enter_Vehicle_Data
    [Documentation]    No.2 กรอกข้อมูลรถ Automobile ตาม Lab11-001
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
    [Documentation]    No.3 กรอกข้อมูลผู้เอาประกัน
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
    [Documentation]    No.4 กรอกข้อมูล Product - หมายเหตุ: ใช้ 12/01/2026 แทน 10/01/2026 เพราะระบบต้อง Start Date ล่วงหน้า >30 วัน (ทดสอบ 14/09/2026)
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
    [Documentation]    No.5 เลือก Silver
    Execute Javascript    document.querySelectorAll("label.choosePrice span.ideal-radio")[0].click();
    Sleep    2s
    Execute Javascript    document.getElementById('nextsendquote').click();
    Sleep    3s
    Page Should Contain    Send Quote
    Capture Page Screenshot    TC05_Price.png

TC06_Send_Quote
    [Documentation]    No.6 ส่งอีเมลขอใบเสนอราคา
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
