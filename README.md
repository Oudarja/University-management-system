This project is a plain Java project created as part of my learning journey in Object-Oriented Programming (OOP). It does not utilize any build tools like Maven or Gradle.

As a result, several JAR files had to be manually added to the project to incorporate the necessary dependencies. In contrast, projects created using build tools such as Maven or Gradle handle dependency management automatically, including downloading and linking JAR files.

To integrate this project into Visual Studio Code (VS Code), I had to manually add the following line to the settings.json file in VS Code:

json
Copy code
"java.project.referencedLibraries": [
    "G:/Jar-20231224T190824Z-001/rs2xml.jar"
]
This ensures that the project can locate and use the associated JAR files.
