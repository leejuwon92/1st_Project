--Ȯ���� ���� ���̺�� - route
--��� ���̺� - place
--����� ���̺� - seoul
--�������̺� -hospital
--�Կ�ȯ��orȮ���� - patient
--����� ���̺� - clients

create table clients(
clients_id varchar2(20) primary key,--����ھ��̵�
clients_pw varchar2(20) not null,--����ں�й�ȣ
clients_type number not null, --����� ���� 1 = �Ϲ��� 2= Ȯ���� 3= ����
clients_addr varchar2(30)
);

create sequence patient_no
start with 1
increment by 1
nocache;

create table patient(
patient_no number primary key,--ȯ�ڹ�ȣ
regdate date not null,--Ȯ����¥
dis_state number not null,--��ġ���� 1=Ȯ��ȯ�� 0=��ġ ------------dis_state
clients_id varchar2(20) references clients(clients_id) not null,--����ھ��̵�
hospital_code varchar2(20) references hospital(hospital_code) not null
);



create table hospital(
hospital_code varchar2(20) primary key,
medi_staff number,--�Ƿ���
hospital_name varchar2(50) not null,
bed_no number,--�����
hospital_addr varchar2(50) not null,
patient_curr number,--����ȯ�ڼ�
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

insert into drug values('���׷��౹', '����� ������', 10);

insert into route values('������', 'A', 1, '2020-09-02');

insert into place values('A', '�Ĵ�');

insert into seoul values('������', 57, '��');

insert into clients values('id', 'pwd', 1);

insert into hospital values('A01',120,'�ƻ꺴��', 300, '����� ���ı�', 1, 'id');

insert into patient values(1, sysdate, 1, 'id', '����� ���ϱ�', 'A01');


select * from drug; --������ ���� �Ϸ�.
select * from route;
select * from place; --�Ϸ�
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
