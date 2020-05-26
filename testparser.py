from os import system

NUMBER_OF_TESTS = 19

system("cd src/ ; javac -Xlint -d ../bin Main.java ; cd ..")

COMMAND_RUN = "cd bin ; java Main < ../tests/fakebook%.2din.txt > ../output-log/fakebook%.2dtest_log.txt"

for i in range(0, NUMBER_OF_TESTS):
	system(COMMAND_RUN % (i+1, i+1))
	code = system("diff output-log/fakebook%.2dtest_log.txt tests/fakebook%.2dout.txt" % (i + 1, i + 1))
	if code != 0:
		print("       FAILED %.2s        " % str(i + 1))
		exit(0)
	else:
		print("       PASSED %.2s        " % str(i + 1))