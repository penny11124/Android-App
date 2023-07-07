# Android-App
## git 小抄
### step.1
1. 根據master複製一個new branch
```git branch <new_branch> <master>```
2. 切換到新創的那個new branch
```git checkout <branch_name>```
### step.2
1. 寫新code
2. push到新的branch
```git add .```
```git commit -m 'description'```
```git push -u <new_branch>```
### step.3
1. 合併到master
在github上面按pull request->ok

### 其他指令
* ```git branch -a``` 看現在有哪些branch
* ```git status``` 看現在有trace哪些file
