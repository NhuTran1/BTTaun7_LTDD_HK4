package com.example.ex2.theme


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    private val viewModel: CourseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseApp(viewModel)
        }
    }
}

@Composable
fun CourseApp(viewModel: CourseViewModel) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectedCourseId by remember { mutableStateOf<Int?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        // Input Fields
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Course Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Course Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Add/Update Button
        Button(
            onClick = {
                if (name.isNotEmpty() && description.isNotEmpty()) {
                    if (selectedCourseId == null) {
                        viewModel.addCourse(name, description)
                    } else {
                        viewModel.updateCourse(selectedCourseId!!, name, description)
                        selectedCourseId = null
                    }
                    name = ""
                    description = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (selectedCourseId == null) "Add Course" else "Update Course")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Course List
        LazyColumn {
            items(viewModel.courseList) { course ->
                CourseItem(
                    course = course,
                    onUpdateClick = {
                        name = it.name
                        description = it.description
                        selectedCourseId = it.id
                    },
                    onDeleteClick = { viewModel.deleteCourse(it) }
                )
            }
        }
    }
}

@Composable
fun CourseItem(course: Course, onUpdateClick: (Course) -> Unit, onDeleteClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = course.name, style = MaterialTheme.typography.bodyLarge)
                Text(text = course.description, style = MaterialTheme.typography.bodyMedium)
            }

            Row {
                Button(onClick = { onUpdateClick(course) }) {
                    Text("Update")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { onDeleteClick(course.id) }) {
                    Text("Delete")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseAppPreview() {
    val previewViewModel = CourseViewModel()

    // Thêm dữ liệu giả để hiển thị trước trong Preview
    previewViewModel.addCourse("Jetpack Compose", "Modern UI toolkit")
    previewViewModel.addCourse("Kotlin Basics", "Introduction to Kotlin programming")
    previewViewModel.addCourse("Android Development", "Build Android apps with Kotlin")

    CourseApp(previewViewModel)
}

