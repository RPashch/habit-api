CREATE TABLE CATEGORY
(
    id          serial PRIMARY KEY,
    title       VARCHAR(250) NOT NULL,
    description VARCHAR(250),
    is_default  boolean,
    created_at  TIMESTAMP DEFAULT timezone('utc', CURRENT_TIMESTAMP)


);

CREATE TABLE public.USER
(
    id         serial PRIMARY KEY,
    user_name  VARCHAR(250),
    first_name VARCHAR(250),
    last_name  VARCHAR(250),
    birth_date DATE,
    created_at TIMESTAMP DEFAULT timezone('utc', CURRENT_TIMESTAMP),
    updated_at TIMESTAMP DEFAULT timezone('utc', CURRENT_TIMESTAMP)

);

CREATE TABLE HABIT
(
    id          serial PRIMARY KEY,
    title       VARCHAR(250) NOT NULL,
    description VARCHAR(250),
    category_id int,
    created_at  TIMESTAMP DEFAULT timezone('utc', CURRENT_TIMESTAMP),
    CONSTRAINT habit_category_category_id_fk
        FOREIGN KEY (category_id)
            REFERENCES CATEGORY (id)
            ON DELETE SET NULL
);

CREATE TABLE USER_HABIT
(
    user_id  int not null
        CONSTRAINT user_habit_user_id_fk
            REFERENCES public.USER
            ON DELETE CASCADE,
    habit_id int not null
        CONSTRAINT habit_user_habit_id_fk
            REFERENCES HABIT
            ON DELETE CASCADE,
    CONSTRAINT user_habit_pk PRIMARY KEY (user_id, habit_id)
);