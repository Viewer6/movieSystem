<el-form-item label="电影链接" prop="movieLink">
  <el-upload
    class="upload-demo"
    action="http://localhost:8080/movie/upload"
    :on-success="handleUploadSuccess"
    :on-error="handleUploadError"
    :before-upload="beforeUpload"
    :file-list="fileList">
    <el-button size="small" type="primary">点击上传</el-button>
    <div slot="tip" class="el-upload__tip">只能上传mp4/mkv文件，且不超过500MB</div>
  </el-upload>
  <el-input v-model="form.movieLink" placeholder="电影链接" style="margin-top: 10px">
    <template slot="prepend">http://</template>
  </el-input>
</el-form-item>

goUrl(row) {
  if (!row.movieLink) {
    this.$message.warning('该电影暂无播放链接');
    return;
  }
  // 如果是完整的URL，直接打开
  if (row.movieLink.startsWith('http://') || row.movieLink.startsWith('https://')) {
    window.open(row.movieLink, '_blank');
  } else {
    // 如果不是完整URL，添加域名
    window.open(`http://localhost:8080${row.movieLink}`, '_blank');
  }
},

// 上传前检查
beforeUpload(file) {
  const isVideo = file.type === 'video/mp4' || file.type === 'video/x-matroska';
  const isLt500M = file.size / 1024 / 1024 < 500;

  if (!isVideo) {
    this.$message.error('只能上传MP4/MKV格式的视频文件！');
    return false;
  }
  if (!isLt500M) {
    this.$message.error('视频大小不能超过500MB！');
    return false;
  }
  return true;
},

// 上传成功回调
handleUploadSuccess(response, file, fileList) {
  if (response.code === 1000) {
    this.$message.success('上传成功');
    this.form.movieLink = response.data; // 设置返回的视频URL
    this.fileList = fileList;
  } else {
    this.$message.error(response.msg || '上传失败');
  }
},

// 上传失败回调
handleUploadError(err) {
  console.error('上传失败：', err);
  this.$message.error('上传失败，请重试');
},

data() {
  return {
    //电影类别
    typeOptions:[],
    //批量删除是否禁用
    isDisable :true,
    //对话框标题
    title:'',
    //对话框
    open :false,
    //多选框选中id与username
    ids :[],
    names:[],
    //查询对象
    query: {
      movieName: '',
      categoryId: '',
      director: '',
      releaseDate: '',
      pageSize: 10,
      pageNum: 1
    },
    movieList:[],
    total:0,
    //用户表单
    form:{
      id:undefined,
      movieName:undefined,
      categoryId:undefined,
      actors:undefined,
      director:undefined,
      duration:undefined,
      releaseDate:undefined,
      movieLink:undefined,
    },
    formRules: {
      movieName: [
        {required: true, message: "请输入电影名称", trigger: "blur"},
      ],
      categoryId: [
        {required: true, message: "请选择电影类别", trigger: "blur"},
      ],
      actors: [
        {required: true, message: "请输入电影演员", trigger: "blur"},
      ],
      director: [
        {required: true, message: "请输入电影导演", trigger: "blur"},
      ],
      duration: [
        {required: true, message: "请输入电影时长", trigger: "blur"},
      ],
      releaseDate: [
        {required: true, message: "请输入电影上映日期", trigger: "blur"},
      ],
      movieLink: [
        {required: true, message: "请上传电影文件或输入电影链接", trigger: "blur"},
      ],
    },
    categoryList: [],
    fileList: [] // 添加文件列表属性
  }
}, 