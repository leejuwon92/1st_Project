--확진자 동선 테이블명 - route
--장소 테이블 - place
--서울시 테이블 - seoul
--병원테이블 -hospital
--입원환자or확진자 - patient
--사용자 테이블 - clients

create table clients(
clients_id varchar2(20) primary key,--사용자아이디
clients_pw varchar2(20) not null,--사용자비밀번호
clients_type number not null, --사용자 구분 1 = 일반인 2= 확진자 3= 병원
clients_addr varchar2(30)
);

create sequence patient_no
start with 1
increment by 1
nocache;

create table patient(
patient_no number primary key,--환자번호
regdate date not null,--확진날짜
dis_state number not null,--완치여부 1=확진환자 0=완치 ------------dis_state
clients_id varchar2(20) references clients(clients_id) not null,--사용자아이디
hospital_code varchar2(20) references hospital(hospital_code) not null
);



create table hospital(
hospital_code varchar2(20) primary key,
medi_staff number,--의료진
hospital_name varchar2(50) not null,
bed_no number,--병상수
hospital_addr varchar2(50) not null,
patient_curr number,--현재환자수
clients_id varchar2(20) references clients(clients_id)
);

create table place(
place_code varchar2(20) primary key,
place_type varchar2(30) not null
);


create table seoul(
district varchar2(30) primary key,
dis_patient number not null,
hazard varchar2(10) not null
);

create table route(
district varchar2(30) references seoul(district),
place_code varchar(20) references place(place_code),
patient_no number references patient(patient_no),
visit_date date
);

create table drug(
d_name varchar2(30) primary key,
d_addr varchar2(50) not null,
mask_num number
);

insert into drug values('빙그레약국', '서울시 강남구', 10);

insert into route values('도봉구', 'A', 1, '2020-09-02');

insert into place values('A', '식당');

insert into seoul values('도봉구', 57, '고');

insert into clients values('id', 'pwd', 1);

insert into hospital values('A01',120,'아산병원', 300, '서울시 송파구', 1, 'id');

insert into patient values(1, sysdate, 1, 'id', '서울시 강북구', 'A01');


select * from drug; --데이터 삽입 완료.
select * from route;
select * from place; --완료
select * from seoul;
select * from clients;
select * from hospital;
select * from patient;

drop table drug;
drop table route;
drop table place;
drop table seoul;
drop table clients;
drop table hospital;
drop table patient;
drop table drug;
