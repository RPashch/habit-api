CREATE TABLE public.USER (
    id serial PRIMARY KEY,
    user_name VARCHAR(250),
    first_name VARCHAR(250),
    last_name VARCHAR(250),
    birth_date DATE,
    created_at TIMESTAMP DEFAULT timezone('utc', CURRENT_TIMESTAMP),
    CONSTRAINT user_habit_user_id_fk
    FOREIGN KEY (id)Ω
        REFERENCES USER_HABIT (user_id)
            ON DELETE CASCADE
);

CREATE TABLE HABIT (
    id serial PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    description VARCHAR(250),
    category_id int,
    created_at TIMESTAMP DEFAULT timezone('utc', CURRENT_TIMESTAMP),
    CONSTRAINT habit_user_habit_id_fk
        FOREIGN KEY (id)
            REFERENCES USER_HABIT (habit_id)
                 ON DELETE CASCADE
);

CREATE TABLE CATEGORY (
    id serial PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    description VARCHAR(250),
	is_default boolean,
    created_at TIMESTAMP DEFAULT timezone('utc', CURRENT_TIMESTAMP),
    CONSTRAINT category_category_id_fk
        FOREIGN KEY (id)
            REFERENCES HABIT (category_id)
                 ON DELETE SET NULL

);

CREATE TABLE USER_HABIT (
    user_id int,
    habit_id int,
	CONSTRAINT user_habit_pk PRIMARY KEY (user_id, habit_id)
);