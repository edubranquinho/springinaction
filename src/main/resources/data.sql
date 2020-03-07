delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;
delete from Ingredient;
insert into Ingredient (id, name, type)
 values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
 values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
 values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type)
 values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type)
 values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type)
 values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type)
 values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
 values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type)
 values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type)
 values ('SRCR', 'Sour Cream', 'SAUCE');

 insert into taco(name, createdat) values ('Delicia', SYSDATE);

 insert into taco_ingredients(taco_id, ingredient_id) values (1, 'FLTO');
 insert into taco_ingredients(taco_id, ingredient_id) values (1, 'COTO');
 insert into taco_ingredients(taco_id, ingredient_id) values (1, 'GRBF');
 insert into taco_ingredients(taco_id, ingredient_id) values (1, 'SLSA');

 insert into taco_order (person_name, street, city, state, zip, ccnumber, ccexpiration, cccvv, placedat)
 values ('Eduardo', 'R. Doutor Nogueira Martins 400', 'SP', 'SP', 4143020, 4716185135817738, '10/28', 153, SYSDATE);

 insert into taco_order_tacos (taco_order_id, taco_id) values (1,1);
