INSERT INTO goal (id, name, description)
VALUES (1, 'Weight Loss', 'Achieve a healthy weight through diet and exercise.');
INSERT INTO goal (id, name, description)
VALUES (2, 'Muscle Gain', 'Build muscle mass and strength through targeted workouts and nutrition.');
INSERT INTO goal (id, name, description)
VALUES (3, 'Improved Cardio', 'Enhance cardiovascular endurance through aerobic exercises.');
INSERT INTO goal (id, name, description)
VALUES (4, 'Flexibility', 'Increase flexibility and range of motion with stretching and mobility exercises.');
INSERT INTO goal (id, name, description)
VALUES (5, 'Meditation', 'Incorporate meditation and mindfulness practices for mental well-being.');
INSERT INTO goal (id, name, description)
VALUES (6, 'Athletic Performance', 'Improve performance in a specific sport or athletic activity.');
INSERT INTO goal (id, name, description)
VALUES (7, 'Stress Reduction', 'Reduce stress levels through various relaxation techniques.');
INSERT INTO goal (id, name, description)
VALUES (8, 'Healthy Eating', 'Adopt a balanced and nutritious diet for overall health.');
INSERT INTO goal (id, name, description)
VALUES (9, 'Posture Improvement', 'Work on correcting and maintaining good posture.');
INSERT INTO goal (id, name, description)
VALUES (10, 'Flexitarian Lifestyle', 'Transition to a more flexible and plant-based diet.');

INSERT INTO diet (goal_id, name, description)
VALUES (1, 'Keto', 'A low-carb, high-fat diet that promotes ketosis.');
INSERT INTO diet (goal_id, name, description)
VALUES (2, 'Paleo', 'A diet based on foods presumed to have been available to early humans.');
INSERT INTO diet (goal_id, name, description)
VALUES (3, 'Mediterranean', 'Emphasizes healthy fats and vegetables.');
INSERT INTO diet (goal_id, name, description)
VALUES (4, 'Vegan', 'Excludes all animal products.');
INSERT INTO diet (goal_id, name, description)
VALUES (5, 'Vegetarian', 'Excludes meat but may include animal products like eggs and dairy.');
INSERT INTO diet (goal_id, name, description)
VALUES (6, 'Gluten-Free', 'Eliminates gluten-containing grains like wheat, barley, and rye.');
INSERT INTO diet (goal_id, name, description)
VALUES (7, 'DASH', 'Dietary Approaches to Stop Hypertension - focuses on lowering blood pressure.');
INSERT INTO diet (goal_id, name, description)
VALUES (8, 'Flexitarian', 'Primarily vegetarian but occasionally includes meat or fish.');
INSERT INTO diet (goal_id, name, description)
VALUES (9, 'Whole30', '30-day diet focused on whole foods and eliminating certain groups.');
INSERT INTO diet (goal_id, name, description)
VALUES (10, 'Intermittent Fasting', 'Cycles between periods of eating and fasting.');

INSERT INTO recipes (id, name,is_vegan, is_vegetarian) VALUES
                                                         (1, 'Recipe 1', true, true),
                                                         (2, 'Recipe 2', false, true),
                                                         (3, 'Recipe 3', false, false),
                                                         (4, 'Recipe 4', true, true),
                                                         (5, 'Recipe 5', false, true),
                                                         (6, 'Recipe 6', true, true),
                                                         (7, 'Recipe 7', false, false),
                                                         (8, 'Recipe 8', false, true),
                                                         (9, 'Recipe 9', true, true),
                                                         (10, 'Recipe 10', true, false);

INSERT INTO products (id, name, description, recipe_id) VALUES
                                                            (1, 'Product 1', 'Description for Product 1', 1),
                                                            (2, 'Product 2', 'Description for Product 2', 2),
                                                            (3, 'Product 3', 'Description for Product 3', 3),
                                                            (4, 'Product 4', 'Description for Product 4', 4),
                                                            (5, 'Product 5', 'Description for Product 5', 5),
                                                            (6, 'Product 6', 'Description for Product 6', 6),
                                                            (7, 'Product 7', 'Description for Product 7', 7),
                                                            (8, 'Product 8', 'Description for Product 8', 8),
                                                            (9, 'Product 9', 'Description for Product 9', 9),
                                                            (10, 'Product 10', 'Description for Product 10', 10);

INSERT INTO customers (id, dob, first_name, last_name, gender, weight, height, is_vegan, is_vegetarian)
VALUES
    (1, '1992-11-09', 'Milord','Snow','Water bender',100,180,true, false),
    (2, '1990-10-19', 'Test1','Apple','Mega tron',120,180,false, false),
    (3, '1892-08-29', 'test2','Pewpew','Avatar',130,180,true, true);

INSERT INTO roles (rolename) VALUES ('admin');
INSERT INTO roles (rolename) VALUES ('user');
-- user pw = user
--admin pw= admin
INSERT INTO users (username, password, email)
VALUES ('admin', '$2a$12$LvdSeFO11/uQxL6waMd1EemHxEpeefd/l12fkvHzl1g04kzPCRaK2','user@user.nl');

INSERT INTO users (username, password, email)
VALUES ('user', '$2a$12$JCLEjYML2gSHtMxgHug8meGpDtjGOOB3f0w6FSNxdZjpC2i7lMbn2', 'user@user.nl'
       );

INSERT INTO users_roles (user_username, roles_rolename) VALUES ('admin', 'admin');
INSERT INTO users_roles (user_username, roles_rolename) VALUES ('admin', 'user');
INSERT INTO users_roles (user_username, roles_rolename) VALUES ('user', 'user');
