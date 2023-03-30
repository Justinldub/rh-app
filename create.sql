create table address (id integer not null auto_increment, city varchar(255), code varchar(255), country varchar(255), province varchar(255), street_name varchar(255), suburb varchar(255), primary key (id)) engine=InnoDB;
create table agreement (id integer not null auto_increment, contract integer, status integer, title integer, employee_id integer, employer_id integer, job_id integer, primary key (id)) engine=InnoDB;
create table blog (id integer not null, message varchar(255), title varchar(255), primary key (id)) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
create table jobs (id integer not null auto_increment, discription varchar(255), roles longblob, salary double precision, status integer, title integer, primary key (id)) engine=InnoDB;
create table news_mail (id integer not null auto_increment, email varchar(255) not null, primary key (id)) engine=InnoDB;
create table user (id integer not null auto_increment, contact_numbers varchar(255), email varchar(255), first_name varchar(255), id_number varchar(255), languages longblob, nationality integer, race varchar(255), role integer, surname varchar(255), address_id integer, primary key (id)) engine=InnoDB;
create table user_agreements (user_id integer not null, agreements_id integer not null) engine=InnoDB;
alter table user_agreements add constraint UK_tnx4m5jfu1fsl2gq2huo7yarn unique (agreements_id);
alter table agreement add constraint FKjda2xpx00iaju58geb9rtik9y foreign key (employee_id) references user (id);
alter table agreement add constraint FK392xuxrxu7ky6w4ejeqrbsxb8 foreign key (employer_id) references user (id);
alter table agreement add constraint FKaq2xr5jvaj58whs0r5m8rfn7n foreign key (job_id) references jobs (id);
alter table user add constraint FKddefmvbrws3hvl5t0hnnsv8ox foreign key (address_id) references address (id);
alter table user_agreements add constraint FKmygcqagr5386wjqgtrf8jjbe foreign key (agreements_id) references agreement (id);
alter table user_agreements add constraint FK3sikry9783obxx8rydpfwcouw foreign key (user_id) references user (id);
