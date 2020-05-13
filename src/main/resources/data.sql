INSERT INTO t_users_security (id, email, password) VALUES
--     pAssword1*
    (1,'user@mail.ru','$2a$10$AO37I3qPsSNA9QTPhMgl4ObM.azg4AexnEQeo/LQlksUJvMmcOx6i'),
--     pAssword2*
    (2,'admin@yandex.ru','$2a$10$uc6tnDdXjm8dy7adRkPO9us/YN.Mm1mpcoO225P.mqwE2E/pzbHv.');

INSERT INTO t_orders (id, name, date) VALUES
    (1,'Computer', TO_DATE('17/12/2015', 'DD/MM/YYYY')),
    (2,'PlayStation', TO_DATE('13/10/2020', 'DD/MM/YYYY')),
    (3,'TV', TO_DATE('22/01/2019', 'DD/MM/YYYY')),
    (4,'Bag', TO_DATE('11/12/2022', 'DD/MM/YYYY')),
    (5,'NoteBook', TO_DATE('10/12/2022', 'DD/MM/YYYY'));