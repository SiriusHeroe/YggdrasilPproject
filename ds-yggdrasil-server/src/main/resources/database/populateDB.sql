INSERT INTO ds_user.t_user (id, email, password, role, customer_id)
VALUES ('600b85d7-3a73-4ddb-b7bb-e11c104cd370', 'vpetrov@jr.com', '123', 'admin', null),
       ('df8835f1-be06-4876-ae93-a7054d64ccac', 'nsukhare@jr.com', '123', 'customer','f9ea598b-d530-4312-97cb-37a4532f1c2e');

INSERT INTO ds_customer.t_customer (id, name, last_name, birthday, passport_num, email, address)
VALUES ('6c659b9d-2aab-4b7c-9510-a119a82709db','Nikolai','Sommererr','1994-05-12','66-66-013013','Test@test.com','Partizana germana 13/22'),
       ('f9ea598b-d530-4312-97cb-37a4532f1c2e','Natalia','Makarchuk','1988-12-29','66-66-013013','Test@test.com','Cherna rechka 13/22');

INSERT INTO ds_contract.t_contract (id, number, tariff_id, customer_id, option_list_id, total_price)
VALUES ('1d80fc9e-dd1b-4b96-aa24-f476ee357216','+7(900)666-66-66','1362d72b-361f-4d32-a74a-6b34d082dfc2','f9ea598b-d530-4312-97cb-37a4532f1c2e','fcf76ff1-54c7-4eff-97aa-efc7d2494620','295.23'),
       ('e089be75-10ac-4a22-a758-4fd74dd6f0be','+7(950)666-13-13','1362d72b-361f-4d32-a74a-6b34d082dfc2','f9ea598b-d530-4312-97cb-37a4532f1c2e','6ac45337-44b2-4707-addd-eb11661553ac','300.00');

INSERT INTO ds_contract.t_option_lists (id, list_id, option_id, status)
VALUES ('8dc8f2dc-a728-46ac-b921-ee9d29ca6072','fcf76ff1-54c7-4eff-97aa-efc7d2494620','b7af3e1a-a96c-4030-98ac-bd3d44425124','custom'),
       ('ec131408-3cf6-493d-a554-df688030e2eb','fcf76ff1-54c7-4eff-97aa-efc7d2494620','bfdc287a-a801-48a7-901e-164611d65f04','default'),
       ('d355a51d-4e10-4fc1-b880-cc2f75f4db2a','6ac45337-44b2-4707-addd-eb11661553ac','bfdc287a-a801-48a7-901e-164611d65f04','default');

INSERT INTO ds_tariff.t_tariff (id, name, description, option_list_id, price)
VALUES ('1362d72b-361f-4d32-a74a-6b34d082dfc2','COVID-19','Memento mori','0975c929-7ff6-4fbe-b33d-5418e27c63d9','120');

INSERT INTO ds_tariff.t_option_lists (id, list_id, option_id)
VALUES ('99a3d5a2-6041-4809-855d-a5cc222aeb6c','0975c929-7ff6-4fbe-b33d-5418e27c63d9','bfdc287a-a801-48a7-901e-164611d65f04');

INSERT INTO ds_option.t_option (id, name, description, price, connection_cost)
VALUES ('b7af3e1a-a96c-4030-98ac-bd3d44425124','Full in','Hello world','100','5.55'),
       ('bfdc287a-a801-48a7-901e-164611d65f04','Black out','Goodbay world','155.5','20');
