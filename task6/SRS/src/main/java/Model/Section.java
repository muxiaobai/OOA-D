package Model;
// Section.java - Chapter 14, Java 5 version.

import java.util.ArrayList;

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.apache.struts2.json.annotations.JSON;
import Enum.EnrollmentStatus;
/**
 *  实际上的课程
 * @author zhang
 * @date  2016年6月21日 下午1:11:56
 * @doing TODO
 * 
 */
@Entity
public class Section {
	//------------
	// Attributes.
	//------------
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer sectionNo;//课程编号
	private char dayOfWeek;
	private String timeOfDay;
	private String room;//教室
	private Integer seatingCapacity;//学分
	@ManyToOne(targetEntity=Course.class,fetch=FetchType.EAGER)
	@JoinColumn(name="course_id",referencedColumnName="id",nullable=false)
	private Course representedCourse;//归属哪一个Course,高数，英语等
	private ScheduleOfClasses offeredIn;
	@ManyToOne(targetEntity=Professor.class,fetch=FetchType.EAGER)
	@JoinColumn(name="professor_id",referencedColumnName="id",nullable=false)
	private Professor instructor;//（哪一个教授）谁教的

	// The enrolledStudents HashMap stores Student object references,
	// using each Student's ssn as a String key.
	//@ManyToOne(targetEntity=Student.class, fetch=FetchType.EAGER)
	//@JoinColumn(name="student_id",referencedColumnName="id",nullable=false)
	@Transient
	private Map<String, Student> enrolledStudents; //哪些学生注册的（String为学生ssn,数据库中为ID,保证唯一）

	// The assignedGrades HashMap stores TranscriptEntry object
	// references, using a reference to the Student to whom it belongs 
	// as the key.
	@OneToMany(targetEntity=TranscriptEntry.class,mappedBy="section",fetch=FetchType.EAGER)
	
	private List<TranscriptEntry> transcriptEntries=new ArrayList<>();
//	@OneToMany(targetEntity=TranscriptEntry.class,mappedBy="section",fetch=FetchType.EAGER)
//	@MapKeyClass(Student.class)
//	@Access(AccessType.FIELD)
//	private Map<Student, TranscriptEntry> assignedGrades=new HashMap<>(); //
	 
	//----------------
	// Constructor(s).
	//----------------
	public Section() {
		// TODO Auto-generated constructor stub
	}
	public Section(int sNo, char day, String time, Course course,
		       String room, int capacity) {
		setSectionNo(sNo);
		setDayOfWeek(day);
		setTimeOfDay(time);
		setRepresentedCourse(course);
		setRoom(room);
		setSeatingCapacity(capacity);

		// A Professor has not yet been identified.

		setInstructor(null);

		// Note that we're instantiating empty support Collection(s).

		enrolledStudents = new HashMap<String, Student>();
		//assignedGrades = new HashMap<Student, TranscriptEntry>();
	}
									
	//------------------
	// Accessor methods.
	//------------------

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSectionNo() {
		return sectionNo;
	}
	public void setSectionNo(Integer sectionNo) {
		this.sectionNo = sectionNo;
	}
	public char getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(char dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getTimeOfDay() {
		return timeOfDay;
	}
	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public Course getRepresentedCourse() {
		return representedCourse;
	}
	public void setRepresentedCourse(Course representedCourse) {
		this.representedCourse = representedCourse;
	}
	public ScheduleOfClasses getOfferedIn() {
		return offeredIn;
	}
	public void setOfferedIn(ScheduleOfClasses offeredIn) {
		this.offeredIn = offeredIn;
	}
	public Professor getInstructor() {
		return instructor;
	}
	public void setInstructor(Professor instructor) {
		this.instructor = instructor;
	}
	public Map<String, Student> getEnrolledStudents() {
		return enrolledStudents;
	}
	public void setEnrolledStudents(Map<String, Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	public List<TranscriptEntry> getTranscriptEntries() {
		return transcriptEntries;
	}
	public void setTranscriptEntries(List<TranscriptEntry> transcriptEntries) {
		this.transcriptEntries = transcriptEntries;
	}
	
	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	// For a Section, we want its String representation to look
	// as follows:
	//
	//	MATH101 - 1 - M - 8:00 AM

	@Override
	public String toString() {
		return "Section [sectionNo=" + sectionNo + ", dayOfWeek=" + dayOfWeek + ", timeOfDay=" + timeOfDay + ", room="
				+ room + ", seatingCapacity=" + seatingCapacity + ", representedCourse=" + representedCourse
				+ ", offeredIn=" + offeredIn + ", instructor=" + instructor + ", enrolledStudents=" + enrolledStudents
				+ "]";
	}

	// The full section number is a concatenation of the
	// course no. and section no., separated by a hyphen;
	// e.g., "ART101 - 1".
	/**
	 * 
	 * @return
	 */
	public String getFullSectionNo() {
		return getRepresentedCourse().getCourseNo() + 
		       " - " + getSectionNo();
	}

	// We use an enum -- EnrollmentStatus -- to return an indication of the
	// outcome of the request to enroll Student s.  See EnrollmentStatus.java
	// for details on this enum.
	/**
	 * 课程接受学生
	 * @param Student
	 * @return 是否注册成功，返回注册结果
	 */
	public EnrollmentStatus enroll(Student s) {
		// First, make sure that this Student is not already
		// enrolled for this Section, and that he/she has
		// NEVER taken and passed the course before.  
		
		
		//得到学生的成绩单
		Transcript transcript = s.getTranscript();
		//判断成绩单中有没有同类课程和对应的Course有没有修好
		if (s.isCurrentlyEnrolledInSimilar(this) || 
		    transcript.verifyCompletion(this.getRepresentedCourse())) {
			return EnrollmentStatus.prevEnroll;
		}

		// If there are any prerequisites for this course,
		// check to ensure that the Student has completed them.
		//得到Course
		Course c = this.getRepresentedCourse();
		if (c.hasPrerequisites()) {
			for (Course pre : c.getPrerequisites()) {
				// See if the Student's Transcript reflects
				// successful completion of the prerequisite.
				//判断先修课是否通过
				if (!transcript.verifyCompletion(pre)) {
					return EnrollmentStatus.prereq;
				}
			}
		}
		
		// If the total enrollment is already at the
		// the capacity for this Section, we reject this 
		// enrollment request.
        //判断已选人数。是否已经选满
		if (!this.confirmSeatAvailability()) {
			return EnrollmentStatus.secFull;
		}
		
		// If we made it to here in the code, we're ready to
		// officially enroll the Student.

		// Note bidirectionality:  this Section holds
		// onto the Student via the HashMap, and then
		// the Student is given a handle on this Section.
		//如果以上条件都满足，则在该课程的enrolledStudents中添加该学生
		//同时在该学生中添加该课程
		enrolledStudents.put(s.getSsn(), s);
		s.addSection(this);
		//最后返回注册很成功
		return EnrollmentStatus.success;
	}
	
	// A private "housekeeping" method.
	/**
	 * 判断是否超过预定人数
	 * @return
	 */
	private boolean confirmSeatAvailability() {
		return (enrolledStudents.size() < getSeatingCapacity())?true:false;
	}
	/**
	 * 课程中删除学生
	 * @param s Student
	 * @return
	 */
	public boolean drop(Student s) {
		// We may only drop a student if he/she is enrolled.
		//判断该学生注册的课程中是否含有该课程Course
		if (!s.isEnrolledIn(this)) return false;
		else {
			// Find the student in our HashMap, and remove it.
			//在该Section中移除该学生
			enrolledStudents.remove(s.getSsn());
			// Note bidirectionality.
			//同时在学生中删除该课程Course
			s.dropSection(this);
			return true;
		}
	}
	/**
	 * 得到该课程的全体学生人数
	 * @return
	 * enrolledStudents 注册学生HashMap
	 */
	@JSON(serialize=false)
	public int getTotalEnrollment() {
		return enrolledStudents.size();
	}	

	public void display() {
		System.out.println("Section Information:");
		System.out.println("\tSemester:  " + getOfferedIn().getSemester());
		System.out.println("\tCourse No.:  " + 
				   getRepresentedCourse().getCourseNo());
		System.out.println("\tSection No:  " + getSectionNo());
		System.out.println("\tOffered:  " + getDayOfWeek() + 
				   " at " + getTimeOfDay());
		System.out.println("\tIn Room:  " + getRoom());
		if (getInstructor() != null) 
			System.out.println("\tProfessor:  " + 
				   getInstructor().getName());
		displayStudentRoster();
	}
	
	public void displayStudentRoster() {
		System.out.print("\tTotal of " + getTotalEnrollment() + 
				   " students enrolled");

		// How we punctuate the preceding message depends on 
		// how many students are enrolled (note that we used
		// a print() vs. println() call above).

		if (getTotalEnrollment() == 0) System.out.println(".");
		else System.out.println(", as follows:");

		// Iterate through all of the values stored in the HashMap.

		for (Student s : enrolledStudents.values()) {
			System.out.println("\t\t" + s.getName());
		}
	}

	// This method returns the value null if the Student has not
	// been assigned a grade.
	@JSON(serialize=false)
	public String getGrade(Student s) {
		String grade = null;

		// Retrieve the associated TranscriptEntry object for this specific 
		// student from the assignedGrades HashMap, if one exists, and in turn 
		// retrieve its assigned grade.

//		TranscriptEntry te = assignedGrades.get(s);
//		if (te != null) {
//			grade = te.getGrade(); 
//		}

		// If we found no TranscriptEntry for this Student, a null value
		// will be returned to signal this.

		return grade;
	}
	/**
	 * 给成绩
	 * @param s Student
	 * @param grade 成绩
	 * @return
	 */
	public boolean postGrade(Student s, String grade) {
		// First, validate that the grade is properly formed by calling
		// a utility method provided by the TranscriptEntry class.

		if (!TranscriptEntry.validateGrade(grade)) return false;

		// Make sure that we haven't previously assigned a
		// grade to this Student by looking in the HashMap
		// for an entry using this Student as the key.  If
		// we discover that a grade has already been assigned,
		// we return a value of false to indicate that
		// we are at risk of overwriting an existing grade.  
		// (A different method, eraseGrade(), can then be written
		// to allow a Professor to change his/her mind.)

	//	if (assignedGrades.get(s) != null) return false;

		// First, we create a new TranscriptEntry object.  Note
		// that we are passing in a reference to THIS Section,
		// because we want the TranscriptEntry object,
		// as an association class ..., to maintain
		// "handles" on the Section as well as on the Student.
		// (We'll let the TranscriptEntry constructor take care of
		// linking this T.E. to the correct Transcript.)

		TranscriptEntry te = new TranscriptEntry(s, grade, this);

		// Then, we "remember" this grade because we wish for
		// the connection between a T.E. and a Section to be
		// bidirectional.

	//	assignedGrades.put(s, te);

		return true;
	}
	/**
	 * 判断 该Course是否属于该Section
	 * @param c Course
	 * @return 
	 */
	public boolean isSectionOf(Course c) {
		if (c == representedCourse) return true;
		else return false;
	}
}
