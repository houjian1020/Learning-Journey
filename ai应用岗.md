==============================================选择ai应用岗 原因====================================================
直接给你结论：
大模型应用岗 > 大模型开发岗
更快入门、更快就业、岗位更多、对数学 / 底层要求更低。
我现在只针对「应用岗」，给你做一套：
最快 30 天入门、2 个月能投 BOSS、能拿到 offer 的极简学习路线。
一、为什么选「应用岗」更快就业
   应用岗 = 大模型前端 / 后端工程师（会用 AI 就行，不用造 AI）
   不用懂太多深度学习、数学、训练
   不用显卡、不用训模型、不用调 LoRA
   纯工程 + 业务，程序员天然优势
   BOSS 上岗位量 是开发岗的 3～5 倍
   起薪不低：8k–25k 非常普遍
   应用岗你要会的就 4 件事：
   调用大模型 API（豆包 / OpenAI / 阿里 / 百度）
   做 RAG 私有知识库（企业刚需）
   用 LangChain / LlamaIndex 做流程
   用 FastAPI + Streamlit 做上线 Demo
二、30 天极速入门路线（每天 2–3 小时）
   第 1 阶段：7 天 —— 环境 + 基础（无难度）
   目标：能写 Python 调用大模型 API
   Python 基础巩固（你是程序员，1 天够）
   函数、类、异步、请求库
   Linux + Git + 环境管理
   conda、pip、git
   必学：调用大模型 API
   豆包 API / OpenAI API
   写一个简单聊天机器人
   产出：
   一个能跑的 Python 版 AI 聊天脚本 → GitHub 上传
   第 2 阶段：10 天 —— RAG（企业刚需，必学）
   目标：做一个「私有文档问答系统」
   你只学这些：
   文档加载：PDF/Word/Excel/Markdown
   文本分块（Chunk）
   Embedding 向量
   向量库：Chroma / FAISS
   检索 + 生成
   工具栈（最简）：
   LangChain 或 LlamaIndex（二选一，我推荐 LangChain）
   模型用：Qwen、DeepSeek、豆包 API
   产出：
   本地可运行的 PDF 知识库问答工具
   第 3 阶段：7 天 —— 做界面 + 上线
   Streamlit（超级简单）
   FastAPI 做接口
   Docker 打包（会复制命令就行）
   产出：
   一个能对外访问的 Web 应用
   别人打开浏览器就能用你的 AI 工具。
   第 4 阶段：6 天 —— 强化 + 简历项目
   做 2 个可写进简历的完整项目：
   项目 1：企业知识库问答系统
   技术：LangChain + RAG + Streamlit
   亮点：多文件上传、历史对话、引用来源展示
   项目 2：AI 办公助手（总结 / 表格 / 问答）
   技术：Prompt 工程 + 工具调用
   亮点：可直接演示给面试官
三、你最终掌握的技能栈（BOSS 必收）
   必写简历技能：
   Python
   大模型 API 调用
   RAG 检索增强生成
   LangChain
   Streamlit / FastAPI
   Docker 部署
   Prompt 工程
   这些就是80% 公司招「大模型应用工程师」的要求。
四、最适合你的学习平台（免费 + 高效）
   1. B 站（直接搜名字）
      林粒粒呀
      李沐（只看应用部分）
      朝发（工程化）
      小鸡炖技术
      陆吾丶
   2. 文档
      LangChain 官方文档
      Hugging Face 文档
      豆包 API 文档
   3. 实战项目
      GitHub 搜：
      langchain-chatchat
      rag-demo
      llm-agent
      五、你能投的岗位（BOSS 直接搜）
      大模型应用工程师
      AI 应用开发工程师
      LLM 应用工程师
      RAG 工程师
      AI 知识库工程师
      大模型后端工程师
      这些岗位，你学完这套全部能投。
      六、我可以下一步帮你：
      你只要告诉我一句：
      “给我做每日计划”
      我直接给你：
      30 天每天学什么、看什么视频、写什么代码、做什么项目
      你照着做，就能就业。
   =========================================================学习路线=====================================================
总技术栈（只学这些）
   一、第 1 周：环境 + 基础（Python/API/Git/Streamlit）
      Day1 Python 快速复习（程序员 1 天）
      视频（首选）
      B 站：黑马程序员 Python 快速入门（3 小时）（只看函数、类、列表 字典、文件、JSON、requests）
      B 站：李沐 Python for AI（2 小时）（适合 AI 场景）
      博客
      廖雪峰 Python 教程（https://www.liaoxuefeng.com/wiki/101695966360240）
      Real Python（https://realpython.com/）
      
      Day2 环境搭建（Anaconda / 虚拟环境）
      视频
      B 站：Anaconda + 虚拟环境 + VSCode 配置（1 小时）3
      B 站：Python AI 开发环境一键配置（30 分钟）
      博客
      官方文档：https://docs.conda.io/projects/conda/en/latest/user-guide/getting-started.html
     
      Day3 Git+GitHub
      视频
      B 站：Git 快速入门（2 小时）（只学 init/add/commit/push）
      B 站：GitHub 项目管理实战（1 小时）
      博客
      廖雪峰 Git 教程（https://www.liaoxuefeng.com/wiki/896043488024272）

      Day4 大模型 API 调用（豆包 / OpenAI）
      视频（首选）
      B 站：豆包 API 快速接入（30 分钟）（成都企业常用）
      B 站：OpenAI API Python 调用（1 小时）
      B 站：大模型 API 封装 + 异常处理（40 分钟）
      博客
      豆包官方文档：https://www.doubao.com/docs/api
      OpenAI Cookbook：https://cookbook.openai.com/
      
      Day5 Prompt 工程（面试必问）
      视频(UP：李沐、林粒粒呀)
      B 站：Prompt 工程实战（2 小时）（角色 / 格式 / 少幻觉）
      B 站：大模型输出 JSON 结构化（1 小时）
      博客
      Learn Prompting（https://learnprompting.org/）
      Prompting Guide（https://www.promptingguide.ai/）
      
      Day6 Streamlit 入门（做界面）
      视频（首选）
      B 站：Streamlit 快速入门（1.5 小时）（输入 / 按钮 / 聊天框）
      B 站：Streamlit + 大模型做聊天界面（1 小时）
      博客
      官方文档：https://docs.streamlit.io/
      Streamlit Gallery（https://streamlit.io/gallery）
   二、第 2 周：RAG 核心（LangChain / 向量库 / 检索）
      Day8 RAG 原理
      视频
      B 站：RAG 原理 + 流程（30 分钟）（只看流程，不抠数学）
      B 站：RAG vs 微调（10 分钟）
      博客
      CSDN：RAG 从入门到精通
      LangChain 官方 RAG 文档：https://python.langchain.com/docs/use_cases/question_answering/
      
      Day9 LangChain 基础
      视频（首选）
      B 站：LangChain 快速入门（2 小时）（DocumentLoader/TextSplitter/Embedding）
      B 站：吴恩达 LangChain 课程（全 8 讲）（DeepLearning.AI，免费）
      慕课网：老顾聊技术 LangChain+RAG 全链路实战（适合 Java 转 AI）
      博客
      LangChain 官方文档：https://python.langchain.com/docs/get_started/introduction
      CSDN：LangChain 实战教程
      
      Day10 向量库（Chroma/FAISS）
      视频
      B 站：Chroma 向量库快速上手（1 小时）
      B 站：FAISS 向量检索实战（1 小时）
      博客
      Chroma 官方：https://docs.trychroma.com/
      FAISS 官方：https://faiss.ai/

      Day11 RAG 基础版
      视频
      B 站：RAG 完整实现（2 小时）（加载→切分→向量化→检索→生成）
      B 站：PDF 问答系统实战（1.5 小时）
      博客
      LangChain RAG 示例：https://python.langchain.com/docs/use_cases/question_answering/quickstart
      
      Day12 RAG 优化（面试加分）
      视频
      B 站：RAG 优化技巧（1 小时）（切分 / 历史 / 引用）
      B 站：解决大模型幻觉（30 分钟）
      博客
      CSDN：RAG 性能优化实战
      
      Day13 RAG+Streamlit
      视频
      B 站：RAG+Streamlit 网页版（1.5 小时）
      B 站：上传文件→问答（1 小时）
      博客
      Streamlit+LangChain 示例：https://docs.streamlit.io/knowledge-base/tutorials/llm-quickstart
   三、第 3 周：Agent + 工具 + FastAPI
      Day15 Agent 原理
      视频
      B 站：AI Agent 原理 + ReAct（1 小时）
      B 站：工具调用机制（30 分钟）
      博客
      LangChain Agent 文档：https://python.langchain.com/docs/modules/agents/
      
      Day16 简单 Agent
      视频
      B 站：LangChain Agent + 计算器 + 搜索（1 小时）
      B 站：AI 自主决策工具调用（1 小时）
      博客
      LangChain Agent 示例：https://python.langchain.com/docs/modules/agents/quick_start
      
      Day17 结构化输出（JSON）
      视频
      B 站：大模型稳定输出 JSON（1 小时）
      B 站：Pydantic+LangChain 结构化（1 小时）
      博客
      LangChain 结构化输出：https://python.langchain.com/docs/modules/model_io/output_parsers/
      
      Day18 AI 内容总结助手
      视频
      B 站：文章总结 + 关键词提取（1 小时）
      B 站：多文档总结（30 分钟）
      博客
      CSDN：AI 内容处理实战
      
      Day19 AI 表格 / 文本处理
      视频
      B 站：CSV/Excel+AI 分析（1 小时）
      B 站：数据清洗 + AI 辅助（1 小时）
      博客
      Pandas+LangChain 示例：https://python.langchain.com/docs/integrations/tools/pandas
      
      Day20 FastAPI 入门
      视频（首选）
      B 站：FastAPI 快速入门（2 小时）（路由 / 参数 / 文档）
      B 站：FastAPI + 大模型 API（1 小时）
      Real Python：Start Building With FastAPI（视频课）
      博客
      官方文档：https://fastapi.tiangolo.com/
      FastAPI+LangChain 示例：https://python.langchain.com/docs/integrations/providers/fastapi
   四、第 4 周：部署 + 简历 + 面试
      Day22 Docker 基础
      视频
      B 站：Docker 快速入门（2 小时）（Dockerfile / 构建 / 运行）
      B 站：AI 项目 Docker 化（1 小时）
      博客
      官方文档：https://docs.docker.com/get-started/
      
      Day23 项目美化（README）
      视频
      B 站：GitHub README 编写技巧（30 分钟）
      B 站：AI 项目文档规范（30 分钟）
      博客
      Awesome README：https://github.com/matiassingers/awesome-readme
      
      Day24-30 简历 + 面试
      视频
      B 站：AI 应用岗简历优化（1 小时）
      B 站：AI 应用岗面试高频题（2 小时）（RAG / 幻觉 / 项目难点）
      博客
      CSDN：AI 应用岗面试宝典
      LeetCode：AI 应用岗面试题
   五、优质博主 / UP 主（持续关注）
      国内（中文，适合成都就业）
      李沐（B 站 / 知乎）：AI 实战，动手学深度学习
      老顾聊技术（慕课网 / B 站）：Java+AI，RAG 实战
      黑马程序员（B 站）：Python/AI 快速入门
      豆包官方（B 站 / 抖音）：豆包 API + 应用实战
      LangChain 中文社区（B 站）：LangChain 最新教程
      国外（英文，进阶）
      Andrew Ng（DeepLearning.AI）：LangChain/Agent 课程
      Harrison Chase（LangChain 创始人）：LangChain 官方教程
      Andrej Karpathy：大模型原理
    六、学习平台汇总（按优先级）
      B 站：免费视频最多，适合快速入门
      慕课网：老顾聊技术等实战课，适合 Java 转 AI
      DeepLearning.AI：吴恩达 LangChain 课程，免费权威
      官方文档：LangChain/Streamlit/FastAPI/Docker，最准确
      CSDN / 知乎：博客 / 问答，解决具体问题
   七、30 天学习节奏建议
      每天 2-3 小时：1 小时视频 + 1.5 小时敲代码 + 0.5 小时整理 GitHub
      每周日复盘：把本周代码整理成项目，写 README
      重点：RAG+LangChain+Streamlit+FastAPI，这 4 个是成都 AI 应用岗面试核心
   八、你只要记住 4 个 UP 主（全部 B 站）
      林粒粒呀 —— 最适合新手、AI 应用实战
      朝发 —— 工程化、RAG、部署
      老顾聊技术 —— Java 转 AI 最友好
      李沐 —— 原理稳、面试稳****

=====================================================面试-公司================================================
职位关键词：AI 应用开发工程师、大模型应用工程师、RAG 工程师、LLM 应用开发（Java）

第一梯队：大厂分舵 / 独角兽（首选，稳定 + 高薪）
   字节跳动（成都）
   业务：豆包生态、企业服务 AI、内容审核大模型
   优势：春招缺口大，接受 Java 转 AI，有完善培训体系
   薪资：20k-30k（你的背景可试 22k-25k）
   关键词：LLM 应用开发、RAG、Agent
   华为成都研究所（高新）
   业务：盘古大模型下游应用、政企 AI 解决方案
   优势：看重工程化能力，你的 Java 经验适配度极高
   薪资：18k-28k（含绩效，稳定）
   关键词：大模型应用集成、Java 后端 + AI 联调
   科大讯飞（成都）
   业务：教育 AI、政务大模型、智能客服
   优势：新手友好，有成熟的 AI 应用框架，无需从 0 搭建
   薪资：16k-24k
   关键词：RAG 知识库、Prompt 工程、行业大模型落地
第二梯队：本土头部企业（次选，落地场景强）
   成都纵横自动化
   业务：工业无人机 + 大模型应用（数据分析、故障诊断）
   优势：制造业 AI 落地刚需，你的 Java 经验可负责后端对接
   薪资：17k-22k
   华栖云（武侯）
   业务：传媒 / 教育大模型应用（内容生成、智能检索）
   优势：接受应届 / 转岗，有实习转正通道，春招招得多
   薪资：15k-20k
   中国网安（天府软件园）
   业务：网络安全 + 大模型（威胁分析、日志检索）
   优势：国企背景，稳定，看重计算机专业 + 工程能力
   薪资：16k-23k（六险一金）
第三梯队：中小厂 / 初创（保底，快速积累项目）
   四川华菁振兴智能技术（郫都）：AI 资料检索、数据治理，新手可入，薪资 10k-15k
   成都万创科技：物联网 + 大模型，Java 后端 + AI 应用开发，薪资 17k-19k