package Model;
// Transcript.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.hibernate.annotations.Parent;

@Embeddable
public class Transcript {
	//------------
	// Attributes.
	//------------
	@ElementCollection(targetClass=TranscriptEntry.class,fetch=FetchType.EAGER)
	private List<TranscriptEntry> transcriptEntries=new ArrayList<>(); //成绩单内包含很多每一条实体（学生-----课程------成绩，张三---哪一个老师的高数---成绩）
	@Parent
	@Transient
	private Student studentOwner;//哪一个学生的成绩单

	//----------------
	// Constructor(s).
	//----------------
	public Transcript() {
		// TODO Auto-generated constructor stub
	}
	public Transcript(Student s) {
		setStudentOwner(s);

		// Note that we're instantiating empty support Collection(s).

		transcriptEntries = new ArrayList<TranscriptEntry>();
	}

	//------------------
	// Accessor methods.
	//------------------

	public void setStudentOwner(Student s) {
		studentOwner = s;
	}

	public Student getStudentOwner() {
		return studentOwner;
	}
	public void setTranscriptEntries(List<TranscriptEntry> transcriptEntries) {
		this.transcriptEntries = transcriptEntries;
	}
	public List<TranscriptEntry> getTranscriptEntries() {
		return transcriptEntries;
	}
	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------
	/**
	 * 判断课程是否已经修过
	 * @param c Course
	 * @return
	 */
	public boolean verifyCompletion(Course c) {
		boolean outcome = false;

		// Step through all TranscriptEntries, looking for one
		// which reflects a Section of the Course of interest.

		for (TranscriptEntry te : transcriptEntries) {
			Section s = te.getSection();

			if (s.isSectionOf(c)) {
			    // Ensure that the grade was high enough.

			    if (TranscriptEntry.passingGrade(te.getGrade())) {
				outcome = true;

				// We've found one, so we can afford to
				// terminate the loop now.

				break;
			    }
			}
		}

		return outcome;
	}

	public void addTranscriptEntry(TranscriptEntry te) {
		transcriptEntries.add(te);
	}

	public void display() {
		System.out.println("Transcript for:  " +
				   getStudentOwner().toString());

		if (transcriptEntries.size() == 0) {
			System.out.println("\t(no entries)");
		}
		else for (TranscriptEntry te : transcriptEntries) {
			Section sec = te.getSection();

			Course c = sec.getRepresentedCourse();

			ScheduleOfClasses soc = sec.getOfferedIn();

			System.out.println("\tSemester:        " +
					   soc.getSemester());
			System.out.println("\tCourse No.:      " +
					   c.getCourseNo());
			System.out.println("\tCredits:         " +
					   c.getCredits());
			System.out.println("\tGrade Received:  " +
					   te.getGrade());
			System.out.println("\t-----");
		}
	}
}
