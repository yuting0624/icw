#!/bin/sh

B=""
T=$(find src -name '*.java' | wc -l)
TS=`expr $T - 1`
A=0
for f in `find src -name '*.java'`; do
    S=""
    for i in `seq $A $TS`; do
        S="$S "
    done
    P=`expr $A \* 100 / $T`
    echo " building... [$B$S] $P %\r\c"

    javac -sourcepath src -classpath "/usr/local/tomcat/lib/*" -encoding UTF-8 -d WebContent/WEB-INF/classes $f
    
    B="$B="
    A=`expr $A + 1`
done
echo " complete... [$B] 100 %"
