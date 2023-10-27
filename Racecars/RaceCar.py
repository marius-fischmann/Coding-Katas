import random


class RaceCar:

    def __init__(self, name, speed):
        self.driver_name = name
        self.speed = speed
        self.distance_traveled = 0

    def drive(self):
        self.distance_traveled += (random.randrange(1, 101) / 100) * self.speed

    def to_string(self):
        return "Name: " + self.driver_name + "\n" + "Distance traveled: " + str(self.distance_traveled)
