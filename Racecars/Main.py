import RaceTrack as track
import RaceCar as car

if __name__ == '__main__':

    # initialize racetrack and racecars
    racetrack = track.RaceTrack(trace_length=1000)
    racetrack.set_car_on_trace(car=car.RaceCar("Heinz", 200))
    racetrack.set_car_on_trace(car=car.RaceCar("Jan", 200))
    racetrack.set_car_on_trace(car=car.RaceCar("Klaas", 200))
    racetrack.set_car_on_trace(car=car.RaceCar("Pitt", 200))

    # run the race
    racetrack.run_race()

