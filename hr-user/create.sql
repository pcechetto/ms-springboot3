create table tb_role (id bigserial not null, role_name varchar(255), primary key (id));
create table tb_user (id bigserial not null, email varchar(255) unique, name varchar(255), password varchar(255), primary key (id));
create table tb_user_role (role_id bigint not null, user_id bigint not null, primary key (role_id, user_id));
alter table if exists tb_user_role add constraint FKea2ootw6b6bb0xt3ptl28bymv foreign key (role_id) references tb_role;
alter table if exists tb_user_role add constraint FK7vn3h53d0tqdimm8cp45gc0kl foreign key (user_id) references tb_user;
