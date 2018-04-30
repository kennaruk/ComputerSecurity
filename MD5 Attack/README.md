MD5 Attack
===
Problem
---
English
```
code a program that can crack password which encypted by MD5

known that password contains fix 4 characters with a-z, A-Z, 0-9

encypted password is in file
ex. acf06cdd9c744f969958e1f085554c8b

Example Input:
% crackpwd file

Example Output:
compare 2123 times
password is "3341"
```
ไทย
```
ให้เขียนโปรแกรม crack password สำหรับ password ที่ใส่รหัสด้วย MD5
ตัวอย่างการ run program
% crackpwd file
compare 2123 times
password is "1234"

ตัวอย่างผลลัพธ์ compare xxxx times โดย xxxx หมายถึงจำนวนครั้งในการนำค่าตัวอย่างมาตรวจสอบเพื่อหาค่ารหัสผ่านขนาด 4 ตัวอักษร 

โดยภายใน file เก็บค่า hash value ในรูปแบบอักขระฐาน 16 จำนวน 32 หลักตัวอย่างดังนี้
acf06cdd9c744f969958e1f085554c8b

ข้อกำหนดของโปรแกรม
1. ใช้ภาษา C/C++/Java เท่านั้น
2. password มีขนาด fix มีอักขระ 4 ตัวอักษร และแต่ละอักขระเป็นตัวอักษร a-z,A-Z และ 0-9 เท่านั้น

ส่งเฉพาะ source code โดยตั้งชื่อไฟล์ ass2_id.c (หรือ ass2_id.cpp หรือ ass2_id.java) โดย id คือรหัสนักศึกษา
ภายในวันที่ 18 พฤษภาคม 2561 เวลา 23:55 เวลาตามเครื่อง server ไม่รับงานที่ส่งล่าช้ากว่ากำหนด
หมานเหตุ:คะแนนเต็ม 100 คะแนน
1. ถ้าใช้แบบ brute force จะได้ 100 คะแนน
2. ถ้าใช้วิธีที่เหาผลลัพธ์ที่ได้ค่าเฉลี่ย compare xxxx น้อยกว่าวิธี brute force จะได้คะแนนเพิ่มเป็น bonus 10 คะแนน
```

Credits
---
* 4 Letters Dictionary
https://www.litscape.com/words/length/4_letters/4_letter_words.html
* MD5 Hash Function (Java)
http://www.asjava.com/core-java/java-md5-example/