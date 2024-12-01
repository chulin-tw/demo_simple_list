const express = require('express');
const path = require('path');
const app = express();
const PORT = 3022;

app.use('/static', express.static(path.join(__dirname, 'public')));
const domain = "192.168.31.221"
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
    }
];
app.get('/list', (req, res) => {
    res.json(data);
});

app.listen(PORT, () => {
    console.log(`Server is running at http://localhost:${PORT}/list`);
});
