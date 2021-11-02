JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = \
        src/Main.java \
        src/passwordGen.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class