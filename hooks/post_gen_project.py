import os

directory = '{{ cookiecutter.__package.replace('.','/') }}'
srcDir = 'src/main/java/' + directory + "/"
testDir = 'src/test/java/' + directory + "/"

os.makedirs(srcDir, exist_ok=True)
os.makedirs(testDir, exist_ok=True)

srcFiles = os.listdir("_src/main/java")
for f in srcFiles:
    os.rename("_src/main/java/" + f, srcDir + f)

testFiles = os.listdir("_src/test/java")
for f in testFiles:
	os.rename("_src/test/java/" + f, testDir + f)

os.system('./mvnw verify')
