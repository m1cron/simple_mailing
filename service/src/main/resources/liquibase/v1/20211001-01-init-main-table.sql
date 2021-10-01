create table users (
    "user_id"           uuid not null,
    "date_of_birth"     date not null,
    "mail"              varchar(64),
    "mailing"           boolean default true,

    primary key (
                "user_id"
        )
);