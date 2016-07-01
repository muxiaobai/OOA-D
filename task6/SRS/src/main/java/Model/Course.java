package Model;
// Course.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Course {
	//------------
	// Attributes.
	//------------
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String courseNo;//course号
	private String courseName;//course名
	private Double credits;//学分
	@OneToMany(targetEntity=Section.class,mappedBy="representedCourse",fetch=FetchType.EAGER)
	private List<Section> offeredAsSection=new ArrayList<>(); //哪些课程属于该Course
	@OneToMany(targetEntity=Course.class,fetch=FetchType.EAGER)
	private List<Course> prerequisites=new ArrayList<>(); //先修Course
	
	//----------------
	// Constructor(s).
	//----------------
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(String cNo, String cName, double credits) {
		setCourseNo(cNo);
		setCourseName(cName);
		setCredits(credits);

		// Note that we're instantiating empty support Collection(s).

		offeredAsSection = new ArrayList<Section>();
		prerequisites = new ArrayList<Course>();
	}

	//------------------
	// Accessor methods.
	//------------------
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setCourseNo(String cNo) {
		courseNo = cNo;
	}
	
	public String getCourseNo() {
		return courseNo;
	}
	
	public void setCourseName(String cName) {
		courseName = cName;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCredits(double c) {
		credits = c;
	}
	
	public double getCredits() {
		return credits;
	}
	public List<Section> getOfferedAsSection() {
		return offeredAsSection;
	}
	public void setOfferedAsSection(List<Section> offeredAsSection) {
		this.offeredAsSection = offeredAsSection;
	}
	public void setCredits(Double credits) {
		this.credits = credits;
	}
	public void setPrerequisites(List<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}
	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	
	public void display() {
		System.out.println("Course Information:");
		System.out.println("\tCourse No.:  " + getCourseNo());
		System.out.println("\tCourse Name:  " + getCourseName());
		System.out.println("\tCredits:  " + getCredits());
		System.out.println("\tPrerequisite Courses:");

		for (Course c : prerequisites) {
			System.out.println("\t\t" + c.toString());
		}

		// Note use of print vs. println in next line of code.

		System.out.print("\tOffered As Section(s):  ");
		for (Section s : offeredAsSection) {
			System.out.print(s.getSectionNo() + " ");
		}

		// Finish with a blank line.

		System.out.println();
	}
	
	@Override
	public String toString() {
		return getCourseNo() + ":  " + getCourseName();
	}

	public void addPrerequisite(Course c) {
		prerequisites.add(c);
	}

	public boolean hasPrerequisites() {
		if (prerequisites.size() > 0) return true;
		else return false;
	}

	public Collection<Course> getPrerequisites() {
		return prerequisites;
	}

	public Section scheduleSection(char day, String time, String room,
				       int capacity) {
		// Create a new Section (note the creative way in
		// which we are assigning a section number) ...

		Section s = new Section(offeredAsSection.size() + 1, 
				day, time, this, room, capacity);
		
		// ... and then remember it!

		addSection(s);
		
		return s;
	}

	public void addSection(Section s) {
		offeredAsSection.add(s);
	}
}
