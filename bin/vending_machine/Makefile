JFLAGS = -g -Xlint
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

# This uses the line continuation character (\) for readability
# You can list these all on a single line, separated by a space instead.
# If your version of make can't handle the leading tabs on each
# line, just remove them (these are also just added for readability).
CLASSES = Item.java Drink.java Snack.java Vending.java DataFile.java Driver.java   
        
default: classes

classes: Item.java Drink.java Snack.java Vending.java DataFile.java Driver.java
	javac -d ./bin *.java

clean:
	$(RM) *.class
	
run:
	java Driver