import os
import time


class GitCmd(object):
    """Git推送提交的构造函数
    获取当前工作路径
    rootpath 更改工作路径到指定根目录
    filepath 更改工作路径到指定路径
    git指令：追踪所有文件
    git指令：提交更改
    git指令：推送到远程仓库
    保存日志
    """

    def __init__(self, filepath, rootpath="D:"):
        print("current work directory: " + os.getcwd())
        os.chdir(rootpath)
        os.chdir(filepath)
        print("into work repository: " + os.getcwd())

    def git(self):
        """
        git pull
        git add
        git commit
        git push
        :return:
        """
        pull = "git pull"
        add = "git add ."
        commit = '''git commit -a -m "''' \
                 + time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()) \
                 + ''' by Python脚本推送提交"'''
        push = "git push"

        self.cmd(pull)
        self.cmd(add)
        self.cmd(commit)
        self.cmd(push)

    def cmd(self, command):
        """
        :param command:
        :return:
        """
        # os.system(commond)
        log = os.popen(command).readlines()


if __name__ == "__main__":
    filepath = os.getcwd()
    print(filepath)
    GitCmd(filepath).git()
    os.system("pause")
