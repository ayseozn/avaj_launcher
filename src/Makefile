defult: run

build:
	@find * -name "*.java" > sources.txt
	@javac @sources.txt

run: build
#@java -cp . $(shell cat sources.txt | head -n 1 | sed 's/\.java//' | sed 's/\//./g')
	@java -cp . avaj_launcher.Main avaj_launcher/scenario.txt
	@echo "Running the program..."

clean:
	@find . -name "*.class" -exec rm -f {} \;
	@rm -f sources.txt

fclean: clean build

deneme: clean
	@echo "This is a test target."
	@javac avaj_launcher/Main.java
	@java -cp . avaj_launcher.Main avaj_launcher/scenario.txt

.PHONY: build clean fclean run deneme