@echo off
cd ..
javac -d build @argfile.txt
cd build
java Server.Server 1234