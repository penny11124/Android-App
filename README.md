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

## 如果要在本地merge別的分支的code
### step.1
先commit自己的code
```git commit -m 'description'```
```git push -u <new_branch>```
### step.2
再切換到你想要抓的branch，並拉下來
```git checkout <target_branch_name>```
```git pull```
### step.3
切回你原本的branch，並merge
```git checkout <your_branch_name>```
```git merge <target_branch_name>```
### step.4
讀conflict message，手動解決conflict
merge完成


### 其他指令
* ```git branch -a``` 看現在有哪些branch
* ```git status``` 看現在有trace哪些file
