#!/bin/bash


#export PATH=~/java/junit.jar:$PATH



times=10000;
LOGF=~/logs/SopeTests.log

echo '' > $LOGF

exec > >(tee $LOGF)
exec 2>&1



for((c=1; c<=$times; c++))
do

echo "running ${c}" >> $LOGF
java -cp .:/home/dave/workspace/Sope/bin/:/home/dave/java/junit.jar:/home/dave/java/hamcrest-all-1.3.jar org.junit.runner.JUnitCore org.sopeconsulting.sopetests.ZTestHarness 

done
