# My Team
## Which Team Are You Fan Of ?

My Team contains football and basketball teams. The users can select the favorite team with their information (name,surname, city etc.)

##### Requirements :

- Java 8
- Intellij IDEA
- Hibernate (5.2.12)
- Lombok *(version must be __1.16.16__ for getting no errors)*
- MySQL Connector 5.1.46 or later

##### Installation :

1. Open README.md in IMPORT_DATABASE
2. Open project on Intellij IDEA
3. Open Edit Configurations... 
4. Select Module as MyTeam
5. Add VM Options to this parameter : `-javaagent:"/_PROJECT_PATH_/lombok-1.16.16.jar"`
6. Select JRE 1.8 and Apply
7. Right Click my-team-gwt [My Team] on Project Window and Open Module Settings
8. Open Libraries screen Click __+__ > Java and add `lombok-1.16.16` and `mysql-connector-java-5.1.46`
9. Click __+__ > From Maven... search `org.hibernate:hibernate-core:5.2.12.Final` and download.
10. Add Lombok plugin on IDEA -> [link](https://projectlombok.org/setup/intellij)
11. Edit `persistence.xml` 
