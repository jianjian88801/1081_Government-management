const base = {
    get() {
        return {
            url : "http://localhost:8080/zhengfuguanlixitong/",
            name: "zhengfuguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zhengfuguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "政府管理系统"
        } 
    }
}
export default base
