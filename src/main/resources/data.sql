insert into user(id, username, password)
		values
        (1, 'kiran', '$2a$10$Xth.0ywHxxJvIJpd0VT/qek6NR.jO27U3uoBBH8NchkmbU6Fu59wy'),
        (2, 'vinay', '$2a$10$1VET2bTAyapBuNFWe1/isuFnLXlXdChYnlTneqy7sINGspvXqdtK6');

insert into role (id, role_name)
     values
     (1, 'USER'),
     (2, 'ADMIN');

insert into user_roles (user_id, role_id)
    values
    (1,1),
    (2, 2);







