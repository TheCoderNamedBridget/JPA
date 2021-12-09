package model;

import java.time.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity(name = "timeslots")
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = { "days_of_week", "start_time", "end_time" })
})
public class Timeslot {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "timeslot_id")
    private int timeslotId;

    /*
     * 1000000: Sunday
     * 0100000: Monday
     * 0010000: Tuesday
     * 0001000: Wednesday
     * 0000100: Thursday
     * 0000010: Friday
     * 0000001: Saturday
     */
    @Column(name = "days_of_week")
    @NotNull
    private byte daysOfWeek;

    @Column(name = "start_time")
    @NotNull
    private LocalTime startTime;

    @Column(name = "end_time")
    @NotNull
    private LocalTime endTime;

    public Timeslot() {

    }

    public Timeslot(@NotNull byte daysOfWeek, @NotNull LocalTime startTime, @NotNull LocalTime endTime) {
        this.daysOfWeek = daysOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getTimeslotId() {
        return timeslotId;
    }

    /*
     * Timeslot ID is a primary key therefore no setters
     */
    // public void setTimeslotId(int timeslotId) {
    // this.timeslotId = timeslotId;
    // }

    public byte getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(byte daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

}