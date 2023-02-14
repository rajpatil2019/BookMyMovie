CREATE TABLE movie(
  movie_id     NUMBER not null,
  title        VARCHAR2(100),
  description  VARCHAR2(100),
  duration        VARCHAR2(40),
  language          VARCHAR2(20),
  releaseDate VARCHAR2(25),
  country  VARCHAR2(25),
  genre VARCHAR2,
  CONSTRAINT pk_movie PRIMARY KEY (movie_id)
);

CREATE TABLE city(
	city_id NUMBER not null,
	name VARCHAR2(25),
	state VARCHAR2(25),
	zipcode NUMBER,
    CONSTRAINT pk_city PRIMARY KEY (city_id));
    
CREATE TABLE cinema(
	cinema_id NUMBER not null,
	name VARCHAR2(25),
	total_cinema_halls NUMBER,
	city_id NUMBER,
    CONSTRAINT pk_cinema PRIMARY KEY (cinema_id),
    CONSTRAINT fk_city FOREIGN KEY (city_id)
    REFERENCES city(city_id));    
    
CREATE TABLE cinema_hall(
  id NUMBER not null,
  name VARCHAR2(25),
  cinema_id NUMBER,
  CONSTRAINT pk_cinema_hall PRIMARY KEY (id),
  CONSTRAINT fk_cinema FOREIGN KEY (cinema_id)
  REFERENCES cinema(cinema_id));   
  
  CREATE TABLE cinema_seat(
  	id NUMBER not null,
  	seatNumber NUMBER,
  	type VARCHAR2(25),
  	cinema_hall_id NUMBER,
  	CONSTRAINT pk_cinema_seat PRIMARY KEY (id),
  	CONSTRAINT fk_cinema_hall FOREIGN KEY (cinema_hall_id)
  	REFERENCES cinema_hall(id)); 
  	
 CREATE TABLE show(
  	id NUMBER not null,
  	dateTime VARCHAR2(25),
  	startTime VARCHAR2(25),
  	endTime VARCHAR2(25),
  	cinema_hall_id NUMBER,
  	movie_id NUMBER,
  	CONSTRAINT pk_show PRIMARY KEY (id),
  	CONSTRAINT fk_cinema_hall_show FOREIGN KEY (cinema_hall_id)
  	REFERENCES cinema_hall(id),
   	CONSTRAINT fk_movie_show FOREIGN KEY (movie_id)
  	REFERENCES movie(movie_id));  

CREATE TABLE user_info(
  id     NUMBER not null,
  name        VARCHAR2(25),
  secret  VARCHAR2(25),
  email        VARCHAR2(25),
  phone          NUMBER,
  CONSTRAINT pk_user PRIMARY KEY (id)
);
  	  	
CREATE TABLE booking(
  	id NUMBER not null,
  	number_Of_Seats NUMBER,
  	timeStamp VARCHAR2(25),
  	status VARCHAR2(25),
  	user_id NUMBER,
  	show_id NUMBER,
  	CONSTRAINT pk_booking PRIMARY KEY (id),
  	CONSTRAINT fk_show_booing FOREIGN KEY (show_id)
  	REFERENCES show(id),
   	CONSTRAINT fk_show_user FOREIGN KEY (user_id)
  	REFERENCES user_info(id));	
  	
 CREATE TABLE show_seat(
  id     NUMBER not null,
  status        VARCHAR2(25),
  price  NUMBER,
  cinema_seat_id NUMBER,
  show_id NUMBER,
  booking_id NUMBER,
  CONSTRAINT pk_show_seat PRIMARY KEY (id),
  CONSTRAINT fk_cinema_seat_show_seat FOREIGN KEY (cinema_seat_id)
  	REFERENCES cinema_seat(id),
  CONSTRAINT fk_show_show_seat FOREIGN KEY (show_id)
  	REFERENCES show(id),	
  CONSTRAINT fk_booing_show_seat FOREIGN KEY (booking_id)
  	REFERENCES booking(id)
); 	

CREATE TABLE payment(
	id NUMBER not null,
	amount number,
	timestamp VARCHAR2(25),
	discount_coupon_id NUMBER,
	remote_transaction_id NUMBER,
	payment_method VARCHAR2(25),
	booking_id NUMBER,
    CONSTRAINT pk_payment PRIMARY KEY (id),
    CONSTRAINT fk_payment_booking FOREIGN KEY (booking_id)
    REFERENCES booking(id));