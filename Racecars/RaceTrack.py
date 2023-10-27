
class RaceTrack:

    def __init__(self, trace_length):
        self.trace_length = trace_length
        self.trace1 = None
        self.trace2 = None
        self.trace3 = None
        self.trace4 = None

    def run_race(self):
        winner = None
        car_set = {self.trace1, self.trace2, self.trace3, self.trace4}
        while winner is None:
            for car in car_set:
                car.drive()
            winner = self.get_winner()
        print("The winner is: " + "\n" + winner.to_string())

    def get_winner(self):
        winner = None
        if self.trace1.distance_traveled >= self.trace_length:
            winner = self.trace1
        if self.trace2.distance_traveled >= self.trace_length and winner is not None:
            if self.trace2.distance_traveled >= winner.distance_traveled:
                winner = self.trace2
        if self.trace3.distance_traveled >= self.trace_length and winner is not None:
            if self.trace3.distance_traveled >= winner.distance_traveled:
                winner = self.trace3
        if self.trace4.distance_traveled >= self.trace_length and winner is not None:
            if self.trace4.distance_traveled >= winner.distance_traveled:
                winner = self.trace4
        return winner

    def set_car_on_trace(self, car):
        if self.trace1 is None:
            self.trace1 = car
        elif self.trace2 is None:
            self.trace2 = car
        elif self.trace3 is None:
            self.trace3 = car
        elif self.trace4 is None:
            self.trace4 = car
        else:
            print("all traces are already occupied")
