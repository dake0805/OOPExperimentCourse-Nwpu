import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements teaching assistant system
 * 
 * @author npu
 * @version 1.0
 */
public class TeachingAssistantSystem {

	private List<Task> catalogTask;

	private Task currentTask;

	private List<Student> studentDatabase;

	private static BufferedReader stdIn = new BufferedReader(
			new InputStreamReader(System.in));

	private static PrintWriter stdOut = new PrintWriter(System.out, true);

	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	public static void main(String[] args) throws IOException, ParseException {
		TeachingAssistantSystem application = new TeachingAssistantSystem();
		application.run();
	}

	/**
	 * the method to judge the next react
	 * 
	 * @throws IOException
	 *             if there are any errors in input or output
	 * @throws ParseException
	 *             if there are any errors in the process of date transformation
	 */
	private void run() throws IOException {
		int choice = getChoice();
		while (choice != 0) {
			if (choice == 1) {
				displayCatalogTask();
			} else if (choice == 2) {
				try {
					stdOut
							.println("Please enter the code of the task you want to display>> ");
					int code = Integer.parseInt(stdIn.readLine());
					displayTask(code);
				} catch (NumberFormatException e) {
					stdErr.println(e);
				}
			} else if (choice == 3) {
				displayCurrentTask();
			} else if (choice == 4) {
				displayStudentDatabase();
			} else if (choice == 5) {
				try {
					stdOut.println("Please enter the code of the student>> ");
					int code = Integer.parseInt(stdIn.readLine());
					stdOut.println();
					displayTaskList(code);
				} catch (NumberFormatException e) {
					stdErr.println(e);
				}
			} else if (choice == 6) {
				registerCurrentTask();
			} else if (choice == 7) {
				Student student = readStudent();
				while (student == null)
					student = readStudent();
				removeStudentFromDB(student);
			} else if (choice == 8) {
				Task task = readTask();
				while (task == null)
					task = readTask();
				removeTaskFromCatalog(task);
			}
			choice = getChoice();
		}
		stdOut.println("Bye!");
	}

	/**
	 * the method to print menu and get the input
	 * 
	 * @return the input
	 * @throws IOException
	 *             if there are any errors in the input or output
	 */
	private int getChoice() throws IOException {
		int input;
		do {
			try {
				stdOut.println();
				stdOut.print("[0] Quit\n" + "[1] Display the task catalog\n"
						+ "[2] Display a task published by task code\n"
						+ "[3] Display the current task\n"
						+ "[4] Display the student database\n"
						+ "[5] Display the task of a student by student code\n"
						+ "[6] Register the current task\n"
						+ "[7] Remove a student by student code\n"
						+ "[8] Remove a task  by task code\n" + "choice>> \n");
				stdOut.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdOut.println();

				if (0 <= input && input <= 8) {
					break;
				} else {
					stdErr.print("Invalid choice: " + input);
				}
			} catch (NumberFormatException nfe) {
				stdErr.println(nfe);
			}
		} while (true);
		return input;
	}

	/**
	 * the constructor
	 * 
	 * @throws ParseException
	 *             if there are any errors in the process of date transformation
	 */
	private TeachingAssistantSystem() throws ParseException {
		this.catalogTask = loadCatalog();
		this.currentTask = loadCurrentTask();
		this.studentDatabase = loadStudent();
	}

	/**
	 * load catalog of task
	 * 
	 * @return return the list of task
	 * @throws ParseException
	 *             if there are any errors in the process of the date
	 *             transformation
	 */
	private List<Task> loadCatalog() throws ParseException {
		List<Task> taskList = new ArrayList<Task>();
		Task math = new Homework(1, "Math", "math homework", "2018-09-18", 0,
				"2018-09-21");
		taskList.add(math);
		Task algorithm = new Homework(2, "Algorithm", "algorithm homework",
				"2018-09-15", 0, "2018-09-18");
		taskList.add(algorithm);
		Task computerScience = new Experiment(3, "Computer Science",
				"computer science experiment", "2018-09-13", 0, "2018-09-18", 2);
		taskList.add(computerScience);
		Task networkingProgramming = new Experiment(4, "Network Programming",
				"network programming experiment", "2018-09-12", 0,
				"2018-09-22", 4);
		taskList.add(networkingProgramming);
		Task numericalAnalysis = new ClassroomTask(5, "Numerical Analysis",
				"numerical analysis classroom task", "2018-09-6", 0);
		taskList.add(numericalAnalysis);
		Task dataMining = new ClassroomTask(6, "Data Mining",
				"data mining classroom task", "2018-09-3", 0);
		taskList.add(dataMining);
		return taskList;
	}

	/**
	 * load the list of student
	 * 
	 * @return the list of student
	 */
	private List<Student> loadStudent() {
		List<Student> studentList = new ArrayList<Student>();

		Student thomas = new Student(1, "Thomas");
		TaskScore thomasTaskScore_0 = new TaskScore(87, catalogTask.get(0),
				thomas);
		TaskScore thomasTaskScore_1 = new TaskScore(92, catalogTask.get(1),
				thomas);
		TaskScore thomasTaskScore_2 = new TaskScore(85, catalogTask.get(2),
				thomas);
		TaskScore thomasTaskScore_3 = new TaskScore(97, catalogTask.get(3),
				thomas);
		TaskScore thomasTaskScore_4 = new TaskScore(87, catalogTask.get(4),
				thomas);
		TaskScore thomasTaskScore_5 = new TaskScore(94, catalogTask.get(5),
				thomas);
		thomas.addTaskScore(thomasTaskScore_0);
		thomas.addTaskScore(thomasTaskScore_1);
		thomas.addTaskScore(thomasTaskScore_2);
		thomas.addTaskScore(thomasTaskScore_3);
		thomas.addTaskScore(thomasTaskScore_4);
		thomas.addTaskScore(thomasTaskScore_5);
		studentList.add(thomas);

		Student james = new Student(2, "James");
		TaskScore jamesTaskScore_0 = new TaskScore(84, catalogTask.get(0),
				james);
		TaskScore jamesTaskScore_1 = new TaskScore(98, catalogTask.get(1),
				james);
		TaskScore jamesTaskScore_2 = new TaskScore(83, catalogTask.get(2),
				james);
		TaskScore jamesTaskScore_3 = new TaskScore(95, catalogTask.get(3),
				james);
		TaskScore jamesTaskScore_4 = new TaskScore(80, catalogTask.get(4),
				james);
		TaskScore jamesTaskScore_5 = new TaskScore(97, catalogTask.get(5),
				james);
		james.addTaskScore(jamesTaskScore_0);
		james.addTaskScore(jamesTaskScore_1);
		james.addTaskScore(jamesTaskScore_2);
		james.addTaskScore(jamesTaskScore_3);
		james.addTaskScore(jamesTaskScore_4);
		james.addTaskScore(jamesTaskScore_5);
		studentList.add(james);

		Student kobe = new Student(3, "Kobe");
		TaskScore kobeTaskScore_0 = new TaskScore(87, catalogTask.get(0), kobe);
		TaskScore kobeTaskScore_1 = new TaskScore(93, catalogTask.get(1), kobe);
		TaskScore kobeTaskScore_2 = new TaskScore(84, catalogTask.get(2), kobe);
		TaskScore kobeTaskScore_3 = new TaskScore(99, catalogTask.get(3), kobe);
		TaskScore kobeTaskScore_4 = new TaskScore(84, catalogTask.get(4), kobe);
		TaskScore kobeTaskScore_5 = new TaskScore(91, catalogTask.get(5), kobe);
		kobe.addTaskScore(kobeTaskScore_0);
		kobe.addTaskScore(kobeTaskScore_1);
		kobe.addTaskScore(kobeTaskScore_2);
		kobe.addTaskScore(kobeTaskScore_3);
		kobe.addTaskScore(kobeTaskScore_4);
		kobe.addTaskScore(kobeTaskScore_5);
		studentList.add(kobe);

		Student curry = new Student(4, "Curry");
		TaskScore curryTaskScore_0 = new TaskScore(82, catalogTask.get(0),
				curry);
		TaskScore curryTaskScore_1 = new TaskScore(99, catalogTask.get(1),
				curry);
		TaskScore curryTaskScore_2 = new TaskScore(86, catalogTask.get(2),
				curry);
		TaskScore curryTaskScore_3 = new TaskScore(96, catalogTask.get(3),
				curry);
		TaskScore curryTaskScore_4 = new TaskScore(80, catalogTask.get(4),
				curry);
		TaskScore curryTaskScore_5 = new TaskScore(94, catalogTask.get(5),
				curry);
		curry.addTaskScore(curryTaskScore_0);
		curry.addTaskScore(curryTaskScore_1);
		curry.addTaskScore(curryTaskScore_2);
		curry.addTaskScore(curryTaskScore_3);
		curry.addTaskScore(curryTaskScore_4);
		curry.addTaskScore(curryTaskScore_5);
		studentList.add(curry);

		Student durant = new Student(5, "Durant");
		TaskScore durantTaskScore_0 = new TaskScore(88, catalogTask.get(0),
				durant);
		TaskScore durantTaskScore_1 = new TaskScore(93, catalogTask.get(1),
				durant);
		TaskScore durantTaskScore_2 = new TaskScore(85, catalogTask.get(2),
				durant);
		TaskScore durantTaskScore_3 = new TaskScore(92, catalogTask.get(3),
				durant);
		TaskScore durantTaskScore_4 = new TaskScore(87, catalogTask.get(4),
				durant);
		TaskScore durantTaskScore_5 = new TaskScore(91, catalogTask.get(5),
				durant);
		durant.addTaskScore(durantTaskScore_0);
		durant.addTaskScore(durantTaskScore_1);
		durant.addTaskScore(durantTaskScore_2);
		durant.addTaskScore(durantTaskScore_3);
		durant.addTaskScore(durantTaskScore_4);
		durant.addTaskScore(durantTaskScore_5);
		studentList.add(durant);

		Student jordan = new Student(6, "Jordan");
		TaskScore jordanTaskScore_0 = new TaskScore(82, catalogTask.get(0),
				jordan);
		TaskScore jordanTaskScore_1 = new TaskScore(96, catalogTask.get(1),
				jordan);
		TaskScore jordanTaskScore_2 = new TaskScore(83, catalogTask.get(2),
				jordan);
		TaskScore jordanTaskScore_3 = new TaskScore(98, catalogTask.get(3),
				jordan);
		TaskScore jordanTaskScore_4 = new TaskScore(81, catalogTask.get(4),
				jordan);
		TaskScore jordanTaskScore_5 = new TaskScore(96, catalogTask.get(5),
				jordan);
		jordan.addTaskScore(jordanTaskScore_0);
		jordan.addTaskScore(jordanTaskScore_1);
		jordan.addTaskScore(jordanTaskScore_2);
		jordan.addTaskScore(jordanTaskScore_3);
		jordan.addTaskScore(jordanTaskScore_4);
		jordan.addTaskScore(jordanTaskScore_5);
		studentList.add(jordan);
		return studentList;
	}

	/**
	 * load current task
	 * 
	 * @return current task
	 * @throws ParseException
	 *             if there are any errors in the process of the date
	 *             transformation
	 */
	private Task loadCurrentTask() throws ParseException {
		Task task = new Homework(7, "Data Structure", "data structure task",
				"2018-9-14", 1, "2018-9-18");
		return task;
	}

	/**
	 * display the catalog of the task
	 */
	public void displayCatalogTask() {
		/* PLACE YOUR CODE HERE */
	}

	/**
	 * display the task by task code
	 * 
	 * @param taskCode
	 *            the code of the task you want to display
	 * @throws IOException
	 */
	public void displayTask(int taskCode) throws IOException {
		/* PLACE YOUR CODE HERE */
	}

	/**
	 * display the current task
	 */
	public void displayCurrentTask() {
		stdOut.println("Current task: " + currentTask.toString());
	}

	/**
	 * display the student database
	 */
	public void displayStudentDatabase() {
		for (Student student : studentDatabase) {
			stdOut.println(student.toString());
		}
	}

	/**
	 * display the task and task score of the student by given student code
	 * 
	 * @param studentCode
	 *            the code of the student
	 */
	public void displayTaskList(int studentCode) {

		/* PLACE YOUR CODE HERE */
	}

	/**
	 * register the current task then the current task will be added to the
	 * catalog of task and create a new current
	 * 
	 * @throws ParseException
	 *             if there are any errors in the process of the date
	 *             transformation
	 */
	public void registerCurrentTask() throws IOException {
		Task currTask = readTask();

		while (currTask == null)
			currTask = readTask();
		/* PLACE YOUR CODE HERE */

	}

	/**
	 * get the catalog of task
	 * 
	 * @return the catalog of the task
	 */
	public List<Task> getCatalogTask() {
		return catalogTask;
	}

	/**
	 * get the current task
	 * 
	 * @return the current task
	 */
	public Task getCurrentTask() {
		return currentTask;
	}

	/**
	 * get the database of student
	 * 
	 * @return the database of student
	 */
	public List<Student> getStudentDatabase() {
		return studentDatabase;
	}

	/**
	 * add new task to the catalog of task
	 * 
	 * @param task
	 *            the new task
	 */
	public void addTaskInCatalogTask(Task task) {
		task.setState(0);
		catalogTask.add(task);
	}

	/**
	 * remove the student from the database of the student
	 * 
	 * @param student
	 *            the student you want to remove
	 */
	public void removeStudentFromDB(Student student) {
		for (Student s : studentDatabase) {
			if (s.equals(student)) {
				studentDatabase.remove(s);
				stdOut.println("remove student successfully!");
				return;
			}
		}

	}

	public void removeTaskFromCatalog(Task task) {
			/* PLACE YOUR CODE HERE */

	}

	/**
	 * Prompts user for a task code and locates the associated <code>Task</code>
	 * object.
	 * 
	 * @return reference to the <code>Task</code> object with the code
	 */
	private Task readTask() throws IOException {

		stdOut.print("Task code> ");
		stdOut.flush();

		try {
			int taskCode = Integer.parseInt(stdIn.readLine());

			for (Task task : catalogTask) {
				if (task.getCode() == taskCode) {
					return task;

				}
			}
		} catch (NumberFormatException nfe) {
			stdErr.println(nfe);
		}
		stdErr.println("There are no task with that code");
		stdErr.flush();
		return null;
	}

	/**
	 * Prompts user for a student code and locates the associated
	 * <code>Student</code> object.
	 * 
	 * @return reference to the <code>Student</code> object with the code
	 */
	private Student readStudent() throws IOException {

		stdOut.print("Student code> ");
		stdOut.flush();
		try {
			int studentCode = Integer.parseInt(stdIn.readLine());
			for (Student student : studentDatabase) {
				if (student.getCode() == studentCode) {
					return student;

				}
			}
		} catch (NumberFormatException nfe) {
			stdErr.println(nfe);
		}
		stdErr.println("There are no student with that code");
		stdErr.flush();
		return null;

	}
}