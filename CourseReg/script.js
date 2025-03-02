function showCourses() {
	fetch("http://localhost:8080/courses")
		.then((response) => response.json())
		.then((data) => {
			const tablebody = document.getElementById("coursetable")
			data.forEach(course => {
				var row = `<tr>
				<td>${course.id}</td>
				<td>${course.courseName}</td>
				<td>${course.duration}</td>
				<td>${course.trainer}</td>
				</tr>`
				tablebody.innerHTML += row;
			});
		});
}

function showEnrolledStudents() {
	fetch("http://localhost:8080/courses/enrolled")
		.then((response) => response.json())
		.then((data) => {
			const tablebody = document.getElementById("enrolledTable")
			data.forEach(student => {
				var row = `<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.email}</td>
				<td>${student.courseName}</td>
				</tr>`
				tablebody.innerHTML += row;
			});
		});
}