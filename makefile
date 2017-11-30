all: begin

begin: Main.class

Main.class: Main.java
	javac -g Main.java

clean:
	rm -f *.class
