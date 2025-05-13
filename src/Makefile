defult: start

start:
	@find * -name "*.java" > sources.txt
	@javac @sources.txt

clean:
	@find . -name "*.class" -exec rm -f {} \;
	@rm -f sources.txt

fclean: clean start

.PHONY: start clean fclean