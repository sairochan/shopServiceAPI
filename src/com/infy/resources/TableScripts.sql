drop table cart;
drop table Users;
drop table Admin;
drop table product;
drop table contactus;
drop table security;

DROP SEQUENCE HIBERNATE_SEQUENCE;

CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

create table contactus(
email varchar2(50) primary key,
name varchar2(50),
message varchar2(150)
);
INSERT INTO contactus VALUES('a','v','c');
select * from contactus;

create table Users(
       emailId VARCHAR2(50) primary key,
       name VARCHAR2(25),
       password VARCHAR2(20),
       phoneNo number(10),
       grandTotal number(20),
 
       constraint uniquePH unique(phoneNo)
);

INSERT INTO Users VALUES('george@gmail.com','George','George@123',9999999999,0);
INSERT INTO Users VALUES('john@gmail.com','John','John@123',9999999998,0);
INSERT INTO Users VALUES('joseph@gmail.com','Joseph','Joseph@123',9999999997,0);
INSERT INTO Users VALUES('jacob@gmail.com','Jacob','Jacob@123',9999999996,0);
INSERT INTO Users VALUES('jerry@gmail.com','Jerry','Jerry@123',9999999995,0);
INSERT INTO Users VALUES('thomas@gmail.com','Thomas','Thomas@123',9999999994,0);
INSERT INTO Users VALUES('ali@gmail.com','Ali','Ali@123',9999999993,0);
INSERT INTO Users VALUES('lee@gmail.com','Lee','Lee@123',9999999992,0);
INSERT INTO Users VALUES('ram@gmail.com','Ram','Ram@123',9999999991,0);
select * from Users;

-----------------------------------------------------

create table Admin(
       username VARCHAR2(25) primary key,
       name VARCHAR2(25),
       password VARCHAR2(25)
);


INSERT INTO Admin VALUES('jishnu@admin','jishnu','jishnu@admin');
INSERT INTO Admin VALUES('manonmani@admin','manonmani','manonmani@admin');
INSERT INTO Admin VALUES('rochan@admin','rochan','rochan@admin');

Select * from Admin;

create table security(
	email VARCHAR2(50) primary key,
	question VARCHAR2(50),
	answer VARCHAR2(40)
);

INSERT INTO security VALUES('george@gmail.com','Name?','George');
select * from security;
------------------------------------------------------

create table product(
       prodid NUMBER(5) primary key,
       prodname VARCHAR2(200),
       category VARCHAR2(40),
       img VARCHAR2(50),
       price NUMBER(10),
       stockavailable NUMBER(10),
       sum NUMBER(10),
       description VARCHAR2(600)
);
INSERT INTO product VALUES(1,'Apple iPhone X (64GB) – Silver','phones','assets/new/phone1.jpg',73900,10,0,'Face ID | IP67 water and dust resistant |12MP dual cameras | Wireless charging');
INSERT INTO product VALUES(2,'Apple iPhone 8 Plus (64GB)','phones','assets/new/phone2.png',64900,10,0,'5.5-inch Retina HD display | 12MP dual cameras with OIS | 7MP FaceTime HD camera with Retina Flash| IP67 water and dust resistant');
INSERT INTO product VALUES(3,'Samsung Galaxy S10 Plus (Grey, 8GB RAM, 128GB Storage) ','phones','assets/new/phone3.png',73900,10,0,'Dual SIM (nano+nano) dual stand by (4G+4G) | 3400mAH lithium-ion battery| Dynamic AMOLED multi-touch capacitive touchscreen | Triple rear camera setup: 16MP with f2.2 aperture ultra wide + 12MP with f1.5 and f2.4 aperture wide + 12MP f2.4 tele| 10MP f1.9 front facing camera');
INSERT INTO product VALUES(4,'Samsung Galaxy S10 (Purple, 8GB RAM, 128GB Storage) ','phones','assets/new/phone4.png',6690,10,0,'Dynamic AMOLED multi-touch capacitive touchscreen | Dual SIM (nano+nano) dual stand by (4G+4G)| Android Pie v9.0 operating system with 2.7GHz + 2.3GHz + 1.9GHz Exynos 9820 octa core processor | 3400mAH lithium-ion battery');
INSERT INTO product VALUES(5,'Mi Z1 (Classic Black, 16 GB) ','phones','assets/new/phone5.png',6690,10,0,'24MP+8MP+2MP Triple rear camera  | 32MP front camera with AI selfie f/2.0 aperture | FHD multi-touch capacitive touchscreen | Dual SIM (micro+nano) dual-standby (4G+4G)| Android v9.0 + EMUI 9.0.1 operating system | Kirin 710 octa core processor');
INSERT INTO product VALUES(6,'Black Berry L21(Indie Black, 8 GB)','phones','assets/new/phone6.png',40000,10,0,'14.48 cm (5.7 Inch) HD+ Dewdrop Notch Display.| 2GB RAM|16GB ROM|Expandable upto 128GB.| 1.6Ghz Octa-core Processor | Android 9.0(Pie) | 8MP+0.3MP Dual Rear Camera | 5MP Front Selfie Camera | 3000 mAh Battery | Dual Sim 4G Volte Support');

INSERT INTO product VALUES(7,'HP 15 Pentium |15.6-inch Laptop (4GB/1TB HDD/Windows 10 Home/Jet Black /2.04 kg), 15q-ds0002TU','electronics','assets/new/electronics1.png',23990,10,0,'Processor: Intel Pentium Silver N5000 (1.1 GHz base processor speed, 4 MB cache, 4 cores) | Max Boost Clock Up to 2.7 Ghz | Operating system: Windows 10 Home | Display: 15.6-inch HD SVA BrightView micro-edge WLED Display (1366 x 768) | Brightness: 220 nits | Memory and Storage: 4GB DDR4-2400 RAM, expandable to 16 GB, Storage: 1TB 5400 RPM HDD');
INSERT INTO product VALUES(8,'ASUS TUF FX504 Intel Core i5 8th Gen 15.6-inch FHD Gaming Laptop (8GB/1TB Hybrid HDD (FireCuda)/Windows 10/GTX 1050 4GB Graphics/Gun Metal/2.30 Kg), FX504GD-E4021T','electronics','assets/new/electronics2.png',60990,10,0,'OS : Windows 10 operating System | Weight : 2.30kg laptop | Keyboard : Highlighted WASD keys | Desktop-inspired Design keyboard |Red Illuminated chiclet keyboard | lifespan of 20 million key press|0.25mm keycap curves |1.8mm of Key travel Distance. Hypercool Technology : Anti-Dust Cooling For Extended Lifespan | Powerful Dual Fan Architecture | Fan Overboost Technology | Patended Thermal-Friendly Chassis | Intelligent Keyboard Cooling.');
INSERT INTO product VALUES(9,'Nikon D3500 W/AF-P DX Nikkor 18-55mm f/3.5-5.6G VR with 16GB Memory Card and Carry Case (Black)','electronics','assets/new/electronics3.png',45999,10,0,'24MP DX-format CMOS sensor with no optical low-pass filter | 39-point AF system with 3D tracking and 3D matrix metering II |5 frames per second continuous shooting | ISO 100 - 12800 (Expandable to 25600)| 5 frames per second continuous shootingISO 100 - 12800 (Expandable to 25600).');
INSERT INTO product VALUES(10,'SONY sz1/fw + Af-P 18-55 Vr Dslr Camera – Black','electronics','assets/new/electronics4.png',46000,10,0,'SONY D-SLR image quality: the large 24.2 MP DX-format sensor wide ISO range of 100-25600 |Snap bridge: Utilises Bluetooth low energy technology 2 to let the D5600 maintain a constant, low-power link with a smartphone or tablet | Vary-angle touchscreen: large 8.1 cm (3.2 inch) LCD with wide viewing-angle and 1,037 k-dot resolution, optical viewfinder: Approximate 95% frame coverage with approx. 0.82x magnification');
INSERT INTO product VALUES(11,'Motorola Pulse 3 Max Wired Headphones (Black)','electronics','assets/new/electronics5.png',1240,10,0,'40mm driver | Ultra light weight with rotating ear cups | Inline microphone | Noise isolation | Get the latest weather updates & listen to your favorite music on the go with one touch access to Alexa');
INSERT INTO product VALUES(12,'Marshall HSB3000 Sound Pro Bluetooth Headset – Grey','electronics','assets/new/electronics6.png',2199,10,0,'Neodymium magnets for powerful bass | Multi device connectivity | Adjustable ear cups | Noise cancellation');

INSERT INTO product VALUES(13,'Stylogue New Rider T-shirt For Men','lifestyle','assets/new/lf1.png',329,50,0,'Style : casual wear | Perfect for : men and boys | Material : denim jeans. wash care instructions : do not bleach, dry in shade | Disclaimer : kindly refer to the size chart (also in images) for fitting measurements');
INSERT INTO product VALUES(14,'Ben Martin Mens Denim Jeans','lifestyle','assets/new/lf2.png',729,50,0,'Style : casual wear | Perfect for : men and boys | Material : denim jeans. wash care instructions : do not bleach, dry in shade | Disclaimer : kindly refer to the size chart (also in images) for fitting measurements');
INSERT INTO product VALUES(15,'Pepe Jeans Womens Button Down Shirt','lifestyle','assets/new/lf3.png',1129,50,0,'100% Cotton | Button Down| Long Sleeve');
INSERT INTO product VALUES(16,'Broadstar Women Denim Light Blue Jeans','lifestyle','assets/new/lf4.png',1799,50,0,'Material Type: Denim | Zip Fly Wit Button Closure | Comfort To Wear With Body Hugging Fit, Making You Look Smart & Slim');
INSERT INTO product VALUES(17,'Clarks Womens Wave Glitz Fashion Sandals','lifestyle','assets/new/lf5.png',1299,50,0,'Closure: Slip On | Material Type: Synthetic | Lifestyle: Evening | Closure Type: Slip On | Heel Type: high');
INSERT INTO product VALUES(18,'1 WALK Comfortable DR Sole Women-Flats/Sandals/Fancy WEAR/Party WEAR/Original/Casual','lifestyle','assets/new/lf6.png',799,50,0,'Sole: Airmax | Closure: snap | Occasion-Casual wear | Sole Material-Airmax | Color-Beige | Outer Material-Synthetic Leather | Closure-Designer Synthetic, long lasting doctor foam');

INSERT INTO product VALUES(19,'Checked Gown for Cuties','kids','assets/new/kids1.png',100000,10,0,'Checked soft gown | 100% Cotton | For kids');
INSERT INTO product VALUES(20,'Pink Comfort (Slippers)','kids','assets/new/kids2.png',100000,10,0,'Slippers | Soft and comfortable | Available in all sizes');
INSERT INTO product VALUES(21,'Blue Kingdom (Gown)','kids','assets/new/kids3.png',100000,10,0,'Blue Comfortable Dress | Available in all sizes');
INSERT INTO product VALUES(22,'Comfort Kingdom (Dress)','kids','assets/new/kids4.png',100000,10,0,'100% Cotton | Shirt and Pants for Boys | Available in all colours');
INSERT INTO product VALUES(23,'Roller Skates (Roll out)','kids','assets/new/kids5.png',100000,10,0,'Roller Skates for Kids | Available in all sizes');
INSERT INTO product VALUES(24,'Shoes for Spartans (Kid Shoes)','kids','assets/new/kids6.png',100000,10,0,'Comfortable waer | Available in all sizes and colours | Easy wear');


INSERT INTO product VALUES(25,'Capresse','bag','assets/handbag1.png',2000,50,0,'Women’s  Handbag | Stylish | Zipper');
INSERT INTO product VALUES(26,'Lavie','bag','assets/handbag2.png',1500,50,0,'Women’s Handbag | Cross Body | Chained Sling Bag');
INSERT INTO product VALUES(27,'Lino Peros','bag','assets/handbag3.png',6000,50,0,'Women’s Handbag | Cross Body | Chained Sling Bag');
INSERT INTO product VALUES(28,'Baggit','bag','assets/handbag4.png',3000,50,0,'Women’s Handbag | Adjustable Strap | Sling Bag');
INSERT INTO product VALUES(29,'Fossil','bag','assets/handbag5.png',5000,50,0,'Girl’s Shoulder Bag | Attractive | Zip Closure');
INSERT INTO product VALUES(30,'Echolac','bag','assets/handbag12.png',2500,50,0,'Student Bag Pack | Travel Bag | Leather');
INSERT INTO product VALUES(31,'Guess','bag','assets/handbag7.png',3500,50,0,'Women’s Clutch | Multicolour | Free Size');
INSERT INTO product VALUES(32,'Chanel','bag','assets/handbag8.png',2300,50,0,'Women’s Clutch | Magnetic Closure | Pvc Material');
INSERT INTO product VALUES(33,'Hidesign','bag','assets/handbag9.png',1300,50,0,'Women’s Clutch | Bridal Purse | Chained Sling Bag');
INSERT INTO product VALUES(34,'Gucci','bag','assets/handbag10.png',4500,50,0,'Women’s Handbag | Cross Body Handbag | Premium Leather');
INSERT INTO product VALUES(35,'Da Milano','bag','assets/handbag11.png',1500,50,0,'Women’s Handbag Satchel | Split Grain Leather | Polyster Lining Inside');
INSERT INTO product VALUES(36,'Esbeda','bag','assets/handbag6.png',2600,50,0,'Women’s Hobo | Ethnic Design | Faux Leather');


select * from product;


 
--------

create table cart(
	   id NUMBER(5) primary key,
       emailId VARCHAR2(50) references Users(emailId),
       prodid NUMBER(5) references product(prodid),
       quantity NUMBER(5)
);


insert into cart values(1,'george@gmail.com',11,5);
insert into cart values(2,'thomas@gmail.com',3,2);
insert into cart values(3,'thomas@gmail.com',3,2);
insert into cart values(4,'lee@gmail.com',3,2);



delete from cart where id=1;
select * from cart where emailId='lee@gmail.com';

select * from cart;








