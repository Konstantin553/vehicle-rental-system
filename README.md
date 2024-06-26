Vehicle rental system that manages the rental and return processes of different types of vehicles. The system should be able to calculate rental and insurance costs based on specific business rules and print out the invoice to the customer. 

Project requirements

Functionality:

- Develop the rental logic using Java
- Available vehicle types are motorcycle, car and cargo van
- Rental information required:
    - Vehicle brand
    - Vehicle model
    - Vehicle value
    - If the vehicle type is car, it also has a car safety rating, the range or rating is 1-5. Vehicle with ratings 4 and 5 are considered to have high safety rating

- If the rental type is motorcycle, information on the rider’s age is needed
- If the rental type is cargo van, information on a driver’s experience is needed
- Rental period
    - For how many days did the customer rent the vehicle

Calculate the rental and insurance cost based on the selected parameters and business rules

All calculations and currency values should be presented with two decimals

Business Rules:

The daily rental cost is $20 for cars, $15 for motorcycles, and $50  for cargo vans if rented for a week or less.

If rented for more than a week, the daily rental cost is $15 for cars, $10 for motorcycles, and $40 for cargo vans.

The insurance cost per day is 0.01% of the car’s value, 0.02% of the motorcycle’s value and 0.03% for the cargo van’s value.

The insurance cost is reduced by 10% for cars with high safety rating, increased by 20% for motorcycles if the rider is under 25 years old, and reduced by 15% for cargo vans if the driver has more than 5 years of experience.

When a vehicle is returned ahead of schedule (rented for 10 days but returned on the 5th day), the customer is charged as follows:

- Rental costs are charged at the full price for the days that have elapsed and half the price for the remaining days
- Insurance coverage is charged at full price for the days that have elapsed and not charged for the remaining days.


