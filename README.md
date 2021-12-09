# Read Me

## Unidirectional
* Section -> Course (example: a Section has a Course field; but a Course does not have a List<Section> field.)
* Section -> TimeSlot
* Student -> Section (for Transcripts)
* Course -> Course (for Prerequisites; a Course should have a list of its prerequisites, but should not have a list of the classes it is prerequisite to)

## Bidirectional
* Semester - Section (example: a Semester has a List<Section> field, and a Section has a Semester field.)
* Course - Department
* Section - Student (for Enrollment)


## Unique Keys
* Course: unique (department ID, number).
* Student: unique studentID.
* TimeSlot: unique (daysOfWeek, startTime, endTime)
* Section: unique (semesterID, courseID, sectionNumber)

## Settings
### persistence.xml
```xml
<property name="jakarta.persistence.jdbc.url" value="jdbc:derby:<INSERT DERBY URL>" />
```
Insert local Derby URL

```xml
<property name="jakarta.persistence.schema-generation.database.action" value="drop-and-create" />
```
Change ```drop-and-create``` to ```create``` if you dont want to drop database


### orm.xml
```xml
<persistence-unit-defaults>
    <schema>JAVAPROJECT</schema>
</persistence-unit-defaults>
```
```JAVAPROJECT``` is the name of the schema created in Derby