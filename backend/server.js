const express = require('express');
const path = require('path');
const app = express();
const PORT = 3022;

app.use('/static', express.static(path.join(__dirname, 'public')));
const domain = '192.168.31.17';
const serverDomain = `http://${domain}:${PORT}`;

const data = [
    {
        userInfo: {
            username: "Rosy",
            avatar: `${serverDomain}/static/avatar/avatar_01.png`,
        },
        momentInfo: {
            text: "非常heart软软的月度老友日",
            picture: [],
        },
    },
    {
        userInfo: {
            username: "Mamika",
            avatar: `${serverDomain}/static/avatar/avatar_02.png`
        },
        momentInfo: {
            text: "大风天和它的绝配搭配————热汤面！",
            picture: [
                `${serverDomain}/static/picture/picture_01.png`
            ]
        },
    },
    {
        userInfo: {
            username: "力速双D弱女子",
            avatar: `${serverDomain}/static/avatar/avatar_03.png`
        },
        momentInfo: {
            text: "明天开始轻断食，轻轻的不断进食",
            picture: [
                `${serverDomain}/static/picture/picture_02.png`,
                `${serverDomain}/static/picture/picture_03.png`,
                `${serverDomain}/static/picture/picture_04.png`
            ]
        }
    }, 
    {
        userInfo: {
            username: "Zack",
            avatar: `${serverDomain}/static/avatar/avatar_04.png`
        },
        momentInfo: {
            text: "看到苏57了,但是手机相机太差比较糊",
            picture: [
                `${serverDomain}/static/picture/picture_05.png`,
                `${serverDomain}/static/picture/picture_06.png`,
                `${serverDomain}/static/picture/picture_07.png`,
                `${serverDomain}/static/picture/picture_08.png`
            ]
        }
    },
    {
        userInfo: {
            username: "浅浅拉",
            avatar: `${serverDomain}/static/avatar/avatar_05.png`
        },
        momentInfo: {
            text: "北京的秋",
            picture: [
                `${serverDomain}/static/picture/picture_09.png`,
                `${serverDomain}/static/picture/picture_10.png`
            ]
        }
    },
     {
            userInfo: {
                username: "Rosy",
                avatar: `${serverDomain}/static/avatar/avatar_01.png`,
            },
            momentInfo: {
                text: "在这个快节奏的世界里，我们常常忘记了停下来欣赏身边的美好。今天，我决定放慢脚步，感受生活的每一个瞬间。早晨的阳光透过窗帘，洒在温暖的被窝上，是新的一天的开始。午后，一杯咖啡，一本好书，静静地坐在窗边，享受这份宁静。傍晚，和朋友们一起散步，分享彼此的故事，感受友情的温暖。生活不在于拥有多少，而在于我们如何去感受和珍惜。愿我们都能在这个喧嚣的世界中，找到属于自己的小确幸。",
                picture: [],
            },
        }
];
app.get('/list', (req, res) => {
    res.json(data);
});

app.listen(PORT, () => {
    console.log(`Server is running at http://localhost:${PORT}/list`);
});
